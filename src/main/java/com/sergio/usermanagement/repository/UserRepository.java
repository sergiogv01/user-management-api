package com.sergio.usermanagement.repository;

import com.sergio.usermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz de acceso a datos para la entidad User.
 * Proporciona las operaciones básicas CRUD gracias a heredar de JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su email
     * Útil para procesos de login y validación de registros duplicados
     *
     * @param email Correo electrónico del usuario.
     * @return Un optional que puede contener al usuario si existe
     */
    // Optional es una clase contenedora que puede contener un valor o estar vacía, evitando así el uso de null
    Optional<User> findByEmail(String email);
}
