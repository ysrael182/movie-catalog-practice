INSERT INTO actor (id, name) VALUES
  ('1', 'Jackie Chan'),
  ('2', 'Matt Daymon');

INSERT INTO movie (movie_id, title, description, rate, registering_user, updating_user, deleted) VALUES
  ('1', 'Pareja Explosive', 'Comedia', 'G', '', '', '0'),
  ('2', 'Ellision', 'Accion', 'G', '', '', '0'),
  ('3', 'oso Ted', 'CoMEdia', 'R', '', '', '0');

INSERT INTO actor_movie (actor_id, movie_id) VALUES
  ('1', '1'),
  ('2', '2'),
  ('2', '3');

INSERT INTO user (id, name) VALUES
  ('1', 'Israel'),
  ('2', 'Yasis');

INSERT INTO member (id, name, telephone, user_name) VALUES
  ('1', 'Israel', '76990278', 'ysra182@gmail.com');

INSERT INTO price (price_id, price) VALUES
  ('1', 12.90),
  ('2', 30.00),
  ('3', 50.00);

INSERT INTO movie_catalog (movie_catalog_id, movie_id, number_copies, price_id) VALUES
  (1, 1, 100, 1),
  (2, 2, 10, 2);

INSERT INTO movie_rental (movie_rental_id, date, return_date, returned_date, status_rental, member_id, movie_catalog_id, movie_id) VALUES
  (1, null, null, null, 'RENTED', 1, 1, 1);

