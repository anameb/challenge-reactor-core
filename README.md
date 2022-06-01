
# Integrantes del grupo: Juan pablo davila, Juliana Camilo Mesa y Ana Milena Estrada.
# Se realizo conexion con la base de datos Mongodb, se realizo la migracion de los datos y se permite la recuperacion de lops mismos desde la base de datos no desde el mismo archivo, se realizaron pruebas con postman para madificar la base de adtos y para buscar, se observo el rendimiento tanto con el test funcional como reactivo. Quedamos atententos---


# Challenge reactor-core

Dentro del código se encutra un ejemplo para aplicar reactividad con Spring Boot, se cuenta con una herramienta utilitaria para leer archivos CSV, lo que se buscar es aplicar los operadores reactivas para leer este archivo, y se reta para hacer este procedimiento en mongodb.

Leer las pruebas unitarias.


# Step by Step

- Transformar un CSV una lista de Stream de Java (Usar operadores basicos)
- En vez de usar Java Stream aplicamos reactividad (Reactor Core) con trasnformaciones (Usar operadores basicos)
- Optimizar las consultas y aplicar un servicio web para hacer estos filtros
- Hacer un proceso de migración en donde tomemos los datos del archivo y lo llevemos a una base datos (MangoDB)
- Trabajo directamente los desde una base de datos reactiva y objserva la rendimiento
- Prueba de concurencia con JMeter, donde vamos a colocar 100 hilos de ejeucución para observar los comportamientos de cada servicio
