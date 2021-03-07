--Database seeding:

-- -Films:
INSERT INTO tb_films (id,name, genre, photo) VALUES (0,'Não escolhido','','');
INSERT INTO tb_films (name, genre, photo) VALUES ('Piratas do Caribe','Aventura','http://wecodecorp.com.br/ufpr/imagens/piratas.jpeg');
INSERT INTO tb_films (name, genre, photo) VALUES ('Passageiros','Ficção','http://wecodecorp.com.br/ufpr/imagens/passageiros.jpeg');
INSERT INTO tb_films (name, genre, photo) VALUES ('La La Land','Musical','http://wecodecorp.com.br/ufpr/imagens/land.jpeg');

-- -Directors:
INSERT INTO tb_directors (id,name) VALUES (0,'Não escolhido');
INSERT INTO tb_directors (name) VALUES ('James Cameron');
INSERT INTO tb_directors (name) VALUES ('Alfred Hitchcoc');
INSERT INTO tb_directors (name) VALUES ('Tim Burton');
INSERT INTO tb_directors (name) VALUES ('Steven Spielberg');


-- -Users:
INSERT INTO tb_users (login, password, token, film_id, director_id) VALUES ('Admin','123',0,0,0);
INSERT INTO tb_users (login, password, token, film_id, director_id) VALUES ('Alessandro','123',0,0,0);
INSERT INTO tb_users (login, password, token, film_id, director_id) VALUES ('Carlos','123',0,0,0);
INSERT INTO tb_users (login, password, token, film_id, director_id) VALUES ('Eduardo','123',0,0,0);
INSERT INTO tb_users (login, password, token, film_id, director_id) VALUES ('Isabelle','123',0,0,0);



