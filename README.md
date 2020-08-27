# 05-Simulacion-MVC-JAVA-SPRING

## Web compuesta de: 
 * Carga de datos: Se debe crear un controlador que permita cargar los datos de las tablas
“posts” y “comments” desde los servicios antes mencionados. Dado que la carga es
completa, antes de realizar el proceso debe procurar eliminar los registros de ambas
tablas. 

* Listado de publicaciones: se debe crear un controlador para desplegar el listado de
publicaciones. Debe mostrar el título, el nombre del usuario que la publicó y la cantidad
de comentarios asociados a ella.

* Listado de comentarios: se debe crear un controlador que despliegue los comentarios de
una publicación. Este método debe recibir como parámetro en la URL el id de la
publicación a analizar, y en base al mismo debe filtrar los comentarios. Se pide desplegar
el campo identificador del comentario, el título o nombre de la publicación y el correo
electrónico. Además, se deben mostrar los primeros 20 caracteres del cuerpo del
comentario. 

## APIREST 

* https://jsonplaceholder.typicode.com/posts: Permite obtener el listado de publicaciones
en formato JSON

* https://jsonplaceholder.typicode.com/comments: Permite obtener el listado de
comentarios en formato JSON

## Script de datos de prueba 

```
insert into users values (1,'Leanne Graham','Bret','Sincere@april.biz');
insert into users values (2,'Ervin Howell','Antonette','Shanna@melissa.tv');
insert into users values (3,'Clementine Bauch','Samantha','Nathan@yesenia.net');
insert into users values (4,'Patricia Lebsack','Karianne','Julianne.OConner@kory.org');
insert into users values (5,'Chelsey Dietrich','Kamren','Lucio_Hettinger@annie.ca');
insert into users values (6,'Mrs. Dennis Schulist', 'Leopoldo_Corkery',
'Karley_Dach@jasper.info');
insert into users values (7,'Kurtis Weissnat','Elwyn.Skiles','Telly.Hoeger@billy.biz');
insert into users values (8,'Nicholas Runolfsdottir V', 'Maxime_Nienow',
'Sherwood@rosamond.me');
insert into users values (9,'Glenna Reichert','Delphine','Chaim_McDermott@dana.io');
insert into users values (10,'Clementina DuBuque', 'Moriah.Stanton',
'Rey.Padberg@karina.biz');```

```
