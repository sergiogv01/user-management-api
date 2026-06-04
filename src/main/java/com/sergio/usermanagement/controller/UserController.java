package com.sergio.usermanagement.controller;

import com.sergio.usermanagement.exceptions.UserNotFoundException;
import com.sergio.usermanagement.models.User;
import com.sergio.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para gestionar las operaciones de usuarios.
 * Expone los endpoints bajo la ruta base /api/users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor para la inyección de dependencias.
     * Spring inyecta automáticamente el Bean de UserService.
     *
     * @param userService El servicio de lógica de negocios de usuarios.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint para obtener la lista de todos los usuarios.
     * Ruta: GET /api/users
     *
     * @return Lista de objetos User en formato JSON.
     */
    @GetMapping
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     * Ruta: POST /api/users
     *
     * @param user Objeto User mapeado automáticamente a JSON.
     * @return El usuario a guardar.
     */
    @PostMapping
    // @RequestBody indica a Spring que el JSON de la petición debe convertirse en objeto User.
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Endpoint para obtener un usuario por su id.
     * Ruta: /api/users/id
     *
     * @param id Id del usuario a obtener.
     * @return Usuario obtenido mediante id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Endpoint para actualizar un usuario existente.
     * Ruta: PUT /api/users/id
     *
     * @param id   Id del usuario a actualizar.
     * @param user El usuario a actualizar.
     * @return El usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Endpoint para eliminar un usuario existente.
     * Ruta: DELETE /api/users/id
     *
     * @param id Id del usuario a eliminar.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Manejador de excepciones para UserNotFoundException.
     * Intercepta el error cuando el usuario no existe y transforma la respuesta
     * en un estado HTTP 404 Not Found con el mensaje de error correspondiente.
     *
     * @param ex La excepción capturada que contiene el mensaje de error.
     * @return ResponseEntity con el mensaje de error en texto y el código 404.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
