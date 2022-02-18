# apirestcrud


Solicitudes validas

http://localhost:8080/usuario                   //ver lista de usuarios
http://localhost:8080/usuario/correos           //correos electronicos de todos los usuarios
http://localhost:8080/usuario/reporte           //reporte de los usuarios de la base de dato
http://localhost:8080/usuario/correos/1         //correos de usuario con prioridad 1 en este caso
http://localhost:8080/usuario/2                 //Encuentra a un usuario por su id en este caso 2
http://localhost:8080/usuario/query?prioridad=1 //encuentra los usuarios con prioridad 1 en este caso

POST:http://localhost:8080/usuario/             //Agrega un nuevo usuario

DELETE:http://localhost:8080/usuario/3            //elimina un usuario deacuerdo a su id 
