API REST - Company API
Este proyecto es una implementación de una API REST en Java 21 usando Spring Boot y MySQL, desarrollada con **arquitectura hexagonal (Domain-Driven Design)**. Permite realizar operaciones CRUD sobre entidades de empresa (`Company`) y consultar aplicaciones y versiones asociadas a una compañía.

 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.6
- Gradle
- Lombok
- MySQL
- Arquitectura Hexagonal
- Tomcat embebido
- JPA (Hibernate)

 Endpoints disponibles

| Método | Ruta                        | Descripción                          |
|--------|-----------------------------|--------------------------------------|
| GET    | `/companies`                | Listar todas las empresas            |
| GET    | `/companies/{id}`           | Obtener empresa por ID               |
| POST   | `/companies`                | Crear una empresa                    |
| PUT    | `/companies/{id}`           | Actualizar una empresa               |
| DELETE | `/companies/{id}`           | Eliminar una empresa                 |
| GET    | `/companies/code/{codigo}`  | Buscar por código y mostrar app + versión |
