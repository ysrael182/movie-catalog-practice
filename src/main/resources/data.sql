INSERT INTO actor (id, name) VALUES
  ('1', 'Jackie Chan'),
  ('2', 'Matt Daymon');

INSERT INTO movie (movie_id, title, description, rate, registering_user, updating_user, deleted) VALUES
  ('1', 'Pareja Explosive', 'Comedia', 'G', '', '', '0'),
  ('2', 'Ellision', 'Accion', 'G', '', '', '0');

INSERT INTO actor_movie (actor_id, movie_id) VALUES
  ('1', '1'),
  ('2', '2');

INSERT INTO user (id, name) VALUES
  ('1', 'Israel'),
  ('2', 'Yasis');

INSERT INTO member (id, name, telephone, user_name) VALUES
  ('1', 'Israel', '76990278', 'ysra182@gmail.com');

INSERT INTO price (price_id, price) VALUES
  ('1', 12.90);