# Biblioteca 2.0

Pequeña aplicación Java que pretende gestionar el proceso de préstamos de un libro en una biblioteca.

## Objetivo

- Introducción a la POO en Java.
- Creación de clases básicas.
- Introducción a la herencia de clases.

## Clases

- [Libro](src/Libro.java): representa un libro presente en la biblioteca.
- [Persona](src/Persona.java): clase padre que representa a cualquier persona.
- [Usuario](src/Usuario.java): clase hija de Persona que representa a un usuario (especificación de persona).
- [Trabajador](src/Trabajador.java): clase hija de Persona que representa a un trabajador (especificación de persona).
- [Préstamo](src/Prestamo.java): representa el prestamo de un libro a un usuario por parte de un trabajador.
- [Main](src/Main.java): programa principal.

### Características

- Comentarios para Javadoc.
- Cada clase cuenta con un main para pruebas unitarias.

## Estructura de carpetas

- `src`: carpeta con el código fuente
- `lib`: librerías para dependencias
- `bin`: carpeta con los ficheros compilados
- `.vscode/settings.json`: configuración del proyecto

## Gestión de dependencias

    https://github.com/microsoft/vscode-java-dependency#manage-dependencies