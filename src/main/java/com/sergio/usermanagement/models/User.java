package com.sergio.usermanagement.models;

import jakarta.persistence.*;

/**
 * Entidad que representa a un usuario dentro del sistema.
 * Esta clase se mapea automáticamente con la tabla 'users' en PostgreSQL mediante JPA/Hibernate.
 */
@Entity // Le dice a Spring que esta clase es una tabla de la DB
@Table(name = "users") // Nombre de la tabla en la DB
public class User {

    /**
     * Identificador único autoincremental.
     */
    @Id
    // @GeneratedValue: Instrucción para generar el valor automáticamente
    // 'strategy' parámetro que define cómo se van a generar los IDs
    // 'GenerationType' es un listado de las formas en que Java crea IDs
    // '.IDENTITY' utiliza la función autoincremental nativa de la DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario único y obligatorio. No puede ser nulo.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Dirección de correo electrónico única y obligatoria. No puede ser nula.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Contraseña encriptada del usuario.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Constructor completo para inicializar un usuario con todas sus propiedades.
     * @param id Identificador único.
     * @param username Nombre de usuario.
     * @param email Correo electrónico.
     * @param password Contraseña.
     */
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor para crear usuario nuevo sin ID (el ID lo generará automáticamente la DB).
     *
     * @param username Nombre de usuario.
     * @param email Correo electrónico.
     * @param password Contraseña.
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor vacío requerido por JPA para la instanciación mediante reflexión.
     */
    public User() {
    }

    /**
     * @return El id del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece o modifica el id del usuario.
     *
     * @param id El nuevo id del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece o modifica el nombre del usuario.
     *
     * @param username El nuevo nombre del usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece o modifica el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece o modifica la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
