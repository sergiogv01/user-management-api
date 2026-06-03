package com.sergio.usermanagement.controller;

import com.sergio.usermanagement.models.User;
import com.sergio.usermanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public User createUser(@RequestBody User user) {
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
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Endpoint para actualizar un usuario existente.
     * Ruta: PUT /api/users/id
     *
     * @param id Id del usuario a actualizar.
     * @param user El usuario a actualizar.
     * @return El usuario actualizado.
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Endpoint para eliminar un usuario existente.
     * Ruta: DELETE /api/users/id
     *
     * @param id Id del usuario a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
