package com.sergio.usermanagement.service;

import com.sergio.usermanagement.models.User;
import com.sergio.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio para la gestión de usuarios.
 * En esta clase se centraliza la lógica de negocio antes de tocar la base de datos.
 */
/*
 * Service le dice a Spring que es una clase componente de lógica
 * Spring crea un Bean de la clase y lo tiene listo por si algún Controller lo necesita
 */
@Service
public class UserService {

    final UserRepository userRepository;

    /**
     * Inyección de dependencias mediante constructor.
     * Spring busca un "bean" del UserRepository y lo entrega aquí.
     *
     * @param userRepository El repositorio del usuario.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Guarda un nuevo usuario validando que el email no esté registrado.
     *
     * @param user Objeto usuario a guardar.
     * @return El usuario guardado.
     */
    public User saveUser(User user) {
        /* Buscamos mediante el email del usuario para ver si ya esta registrado.
         * Si hay coincidencia, obtenemos una variable con objeto User.
         * Si no hay coincidencia, obtenemos una variable vacía.
         */
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        /* Si el Optional tiene un valor, significa que ya existe un usuario con ese email.
         * Por tanto se lanzará una excepción comunicando que el email ya esta registrado.
         */
        if (existingUser.isPresent()) {
            throw new RuntimeException("El email " + user.getEmail() + " ya está registrado.");
        }

        // Si no existe, procedemos a guardar el usuario.
        return userRepository.save(user);
    }

    /**
     * Obtiene la lista de todos los usuarios registrados.
     *
     * @return Lista de entidades User.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
