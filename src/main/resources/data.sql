INSERT INTO actor ( name) VALUES
  ( 'Jackie Chan'),
  ( 'Matt Daymon');

INSERT INTO movie (title, description, rate, registering_user, updating_user, deleted) VALUES
  ( 'Pareja Explosive', 'Comedia', 'G', '', '', '0'),
  ( 'Ellision', 'Accion', 'G', '', '', '0'),
  ( 'oso Ted', 'CoMEdia', 'R', '', '', '0');

INSERT INTO actor_movie (actor_id, movie_id) VALUES
  ('1', '1'),
  ('2', '2'),
  ('2', '3');


INSERT INTO member ( name, telephone, user_name) VALUES
  ( 'Israel', '76990278', 'ysra182@gmail.com');

INSERT INTO price (price) VALUES
  (12.90),
  ( 30.00),
  ( 50.00);

INSERT INTO movie_catalog (movie_movie_id, number_copies, price_id) VALUES
  ( 1, 100, 1),
  ( 2, 10, 2);

INSERT INTO movie_rental (date, return_date, returned_date, status_rental, member_id, movie_catalog_movie_movie_id) VALUES
  ( null, null, null, 'RENTED', 1, 1);

