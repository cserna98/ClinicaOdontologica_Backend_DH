# ClinicaOdontologica_Backend_DH

Sistema de Reserva de Turnos - Readme

Este proyecto es un sistema de reserva de turnos para una clínica odontológica, el cual permite administrar datos de odontólogos y pacientes, y registrar turnos para los mismos.

# Requerimientos funcionales:

Administración de datos de odontólogos: listar, agregar, modificar y eliminar odontólogos. Registrar apellido, nombre y matrícula de los mismos.
Administración de datos de los pacientes: listar, agregar, modificar y eliminar pacientes. De cada uno se almacenan: nombre, apellido, domicilio, DNI y fecha de alta.
Registrar turno: se tiene que poder permitir asignar a un paciente un turno con un odontólogo a una determinada fecha y hora.
Login: validar el ingreso al sistema mediante un login con usuario y password. Se debe permitir a cualquier usuario logueado (ROLE_USER) registrar un turno, pero solo a quienes tengan un rol de administración (ROLE_ADMIN) poder gestionar odontólogos y pacientes. Un usuario podrá tener un único rol y los mismos se ingresarán directamente en la base de datos.

# Requerimientos técnicos:

Desarrollado en capas: capa de entidades de negocio, capa de acceso a datos (Repository), capa de datos (base de datos), capa de negocio y capa de presentación.
Manejo de excepciones: todas las excepciones que se puedan generar son logueadas para su posterior análisis y corrección.
Test unitarios: se han realizado pruebas unitarias para garantizar la calidad de los desarrollos.

# Tecnologías utilizadas:

Java
Spring Boot
Spring Security
Spring Data JPA
H2 database
HTML, JavaScript y/o React para la vista

# Para ejecutar la aplicación:

Descargar o clonar el repositorio.
Ejecutar el archivo "ClinicaDentalApplication.java" ubicado en la ruta src/main/java/com/digitalhouse/clinica/
Acceder a la aplicación a través del navegador, utilizando la URL http://localhost:8080.
Para realizar pruebas:

Ejecutar los archivos de test ubicados en la ruta src/test/java/com/digitalhouse/clinica/.
Este proyecto fue realizado en el marco del aprendizaje para la escuela de Digital House, en la materia de Backend. Cualquier duda o sugerencia, no dude en contactarnos.
