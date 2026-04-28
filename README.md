# User Management API - Spring Boot CRUD
Este es el primer proyecto de mi serie de desarrollo backend, 
enfocado en construir una base sólida y profesional con Spring Boot.
El objetivo es demostrar el dominio de una arquitectura por capas,
validaciones de datos y manejo global de excepciones.

### Características del Proyecto

- **Arquitectura por Capas:** Separación clara entre `Controller`, `Service` y `Repository`.
- **CRUD Completo:** Operaciones de creación, lectura, actualización y borrado de usuarios.
- **Validaciones Robustas:** Uso de `@Valid` para asegurar la integridad de datos (email,
campos obligatorios, etc).
- **Manejo Global de Errores:** Implementación de `Exception Handling` para respuestas API
consistentes.
- **Persistencia de Datos:** Conexión a base de datos real mediante Spring Data JPA.

### Tecnologías Utilizadas

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- Validation API (Hibernate Validator)
- Base de datos: PostgreSQL
- Maven

### Estructura del Código

Desarrollo siguiendo una arquitectura dirigida por el dominio,
priorizando la integridad de la base de datos y la robustez de la
lógica de negocio antes de la exposición de los endpoints

- `controller`: Puntos de entrada de la API.
- `service`: Lógica de negocio y reglas de validación.
- `repository`: Comunicación con la base de datos.
- `entity`: Entidades persistentes que representan tablas de la base de datos.
- `exception`: Gestión y personalización de errores.

### Cómo Ejecutar

1. Clona el repositorio.
2. Configura tu base de datos en `src/main/resources/application.properties`.
3. Ejecuta `./mvnw spring-boot:run`.