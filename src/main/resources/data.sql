/*Creacion de usuarios*/
INSERT INTO users (id, username, email, password, phone)
    VALUES (1, 'edwin estrada', 'prueba1@gmail.com', '123456', '320341');
INSERT INTO users (id, username, email, password, phone)
    VALUES (2, 'Lucas Ramirez', 'prueba2@gmail.com', '12345', '320341');


/*Noticias*/
INSERT INTO news (id,author, content, title)
    VALUES (1,'matt', 'esto es un hola mundo muy largoooo', 'hola mundo');
INSERT INTO news (id,author, content, title) 
    VALUES (2,'andres', 'esto es un hola mundo muy largooooooooooooooooooooooooooo', 'hola mundo');

/*Comentarios*/
INSERT INTO comment (body, user_id) VALUES ('matt the beast',1);