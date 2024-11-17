INSERT INTO vets VALUES (default, 'James', 'Carter');
INSERT INTO vets VALUES (default, 'Helen', 'Leary');
INSERT INTO vets VALUES (default, 'Linda', 'Douglas');
INSERT INTO vets VALUES (default, 'Rafael', 'Ortega');
INSERT INTO vets VALUES (default, 'Henry', 'Stevens');
INSERT INTO vets VALUES (default, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (default, 'radiology');
INSERT INTO specialties VALUES (default, 'surgery');
INSERT INTO specialties VALUES (default, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (default, 'cat');
INSERT INTO types VALUES (default, 'dog');
INSERT INTO types VALUES (default, 'lizard');
INSERT INTO types VALUES (default, 'snake');
INSERT INTO types VALUES (default, 'bird');
INSERT INTO types VALUES (default, 'hamster');

INSERT INTO owners VALUES (default, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners VALUES (default, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO owners VALUES (default, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO owners VALUES (default, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO owners VALUES (default, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO owners VALUES (default, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO owners VALUES (default, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO owners VALUES (default, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO owners VALUES (default, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO owners VALUES (default, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT INTO pets VALUES (default, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets VALUES (default, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets VALUES (default, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets VALUES (default, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets VALUES (default, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets VALUES (default, 'George', '2010-01-20', 4, 5);
INSERT INTO pets VALUES (default, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (default, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (default, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO pets VALUES (default, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets VALUES (default, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO pets VALUES (default, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO pets VALUES (default, 'Sly', '2012-06-08', 1, 10);

INSERT INTO visits VALUES (default, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits VALUES (default, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits VALUES (default, 8, '2013-01-03', 'neutered');
INSERT INTO visits VALUES (default, 7, '2013-01-04', 'spayed');

INSERT INTO students VALUES (default, 'George', 'Franklin', 'Liberty@St.com', '6085551023');
INSERT INTO students VALUES (default, 'Betty', 'Davis', 'Cardinal@Ave.org', '6085551749');
INSERT INTO students VALUES (default, 'Eduardo', 'Rodriquez', 'Commerce@St.com', '6085558763');
INSERT INTO students VALUES (default, 'Harold', 'Davis', 'Friendly@St.com', '6085553198');
INSERT INTO students VALUES (default, 'Peter', 'McTavish', 'Fair@Way,com', '6085552765');
INSERT INTO students VALUES (default, 'Jean', 'Coleman', 'Lake@St.com', '6085552654');
INSERT INTO students VALUES (default, 'Jeff', 'Black', 'Oak@Blvd.org', '6085555387');
INSERT INTO students VALUES (default, 'Maria', 'Escobito', 'Maple@St.com', '6085557683');
INSERT INTO students VALUES (default, 'David', 'Schroeder', 'Blackhawk@Trail.org', '6085559435');
INSERT INTO students VALUES (default, 'Carlos', 'Estaban', 'Independence@La.com', '6085555487');

INSERT INTO courses VALUES (default, 'cat', 'Thranduil', 'books', 'not done', 1);
INSERT INTO courses VALUES (default, 'dog', 'Olorin', 'books', 'done', 2);
INSERT INTO courses VALUES (default, 'lizard', 'Curunir', 'food', 'in progress', 3);
INSERT INTO courses VALUES (default, 'snake', 'Raiwendil', 'food', 'blocked', 4);
INSERT INTO courses VALUES (default, 'bird', 'Lorien', 'housing', 'done', 5);
INSERT INTO courses VALUES (default, 'hamster', 'Nienna', 'utilities', 'not done', 6);

INSERT INTO notes VALUES (default, 'Leo', '2000-09-07', '1, 1', 1);
INSERT INTO notes VALUES (default, 'Basil', '2002-08-06', '6, 2', 2);
INSERT INTO notes VALUES (default, 'Rosy', '2001-04-17', '2, 3', 2);
INSERT INTO notes VALUES (default, 'Jewel', '2000-03-07', '2, 3', 3);
INSERT INTO notes VALUES (default, 'Iggy', '2000-11-30', '3, 4', 4);
INSERT INTO notes VALUES (default, 'George', '2000-01-20', '4, 5', 4);
INSERT INTO notes VALUES (default, 'Samantha', '1995-09-04', '1, 6', 5);
INSERT INTO notes VALUES (default, 'Max', '1995-09-04', '1, 6', 6);
INSERT INTO notes VALUES (default, 'Lucky', '1999-08-06', '5, 7', 7);
INSERT INTO notes VALUES (default, 'Mulligan', '1997-02-24', '2, 8', 8);
INSERT INTO notes VALUES (default, 'Freddy', '2000-03-09', '5, 9', 9);
INSERT INTO notes VALUES (default, 'Lucky', '2000-06-24', '2, 10', 7);
INSERT INTO notes VALUES (default, 'Sly', '2002-06-08', '1, 10', 8);

INSERT INTO assignments VALUES (default, 'cat', '2000-09-07', 'books', 'not done', 1);
INSERT INTO assignments VALUES (default, 'dog', '2001-09-07', 'books', 'done', 2);
INSERT INTO assignments VALUES (default, 'lizard', '2000-09-07', 'food', 'in progress', 3);
INSERT INTO assignments VALUES (default, 'snake', '2000-09-07', 'food', 'blocked', 4);
INSERT INTO assignments VALUES (default, 'bird', '2000-09-07', 'housing', 'done', 5);
INSERT INTO assignments VALUES (default, 'hamster', '2000-09-07', 'utilities', 'not done', 6);
