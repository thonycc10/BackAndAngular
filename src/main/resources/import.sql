

INSERT INTO regiones (nombre) VALUES('Perú');
INSERT INTO regiones (nombre) VALUES('Colombia');
INSERT INTO regiones (nombre) VALUES('Brasil');
INSERT INTO regiones (nombre) VALUES('Canada');
INSERT INTO regiones (nombre) VALUES('Chile');
INSERT INTO regiones (nombre) VALUES('Argentina');
INSERT INTO regiones (nombre) VALUES('Bolivia');

INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'thony', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(2,'gre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(3,'fre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(2,'ru', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(3,'mar', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(2,'hugo', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'thony', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'gre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'fre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(3,'ru', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'mar', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(2,'hugo', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'thony', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(3,'gre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'fre', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(4,'ru', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'mar', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(2,'hugo', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'thony', 'carrascp', 'thony@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, name, apellido, email, create_at) VALUES(1,'gre', 'carrascp', 'thony@gmail.com', '2018-01-01');


INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES('thony', '$2a$10$gfNdof46y.mfBpScJhIaMeL.sy3EO/.APsoqnFl7UReEwl9.4bi5e', true, 'test', 'test', 'test@gmail.com');
INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES('lau', '$2a$10$zSQ7OtAnEKQoBAxOCc4DtuoBLpMChOE7ghB9zH8aJjlHiqY9wc4Su', true, 'test1', 'test1', 'test1@gmail.com');
INSERT INTO user_athority (user_id, rol_id) VALUES(1,1);
INSERT INTO user_athority (user_id, rol_id) VALUES(2,2);

