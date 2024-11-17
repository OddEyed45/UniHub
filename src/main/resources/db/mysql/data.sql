INSERT IGNORE INTO vets VALUES (1, 'James', 'Carter');
INSERT IGNORE INTO vets VALUES (2, 'Helen', 'Leary');
INSERT IGNORE INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT IGNORE INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT IGNORE INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT IGNORE INTO vets VALUES (6, 'Sharon', 'Jenkins');

INSERT IGNORE INTO specialties VALUES (1, 'radiology');
INSERT IGNORE INTO specialties VALUES (2, 'surgery');
INSERT IGNORE INTO specialties VALUES (3, 'dentistry');

INSERT IGNORE INTO vet_specialties VALUES (2, 1);
INSERT IGNORE INTO vet_specialties VALUES (3, 2);
INSERT IGNORE INTO vet_specialties VALUES (3, 3);
INSERT IGNORE INTO vet_specialties VALUES (4, 2);
INSERT IGNORE INTO vet_specialties VALUES (5, 1);

INSERT IGNORE INTO students VALUES (1, 'George', 'Franklin', 'Liberty@St.com', '6085551023');
INSERT IGNORE INTO students VALUES (2, 'Betty', 'Davis', 'Cardinal@Ave.org', '6085551749');
INSERT IGNORE INTO students VALUES (3, 'Eduardo', 'Rodriquez', 'Commerce@St.com', '6085558763');
INSERT IGNORE INTO students VALUES (4, 'Harold', 'Davis', 'Friendly@St.com', '6085553198');
INSERT IGNORE INTO students VALUES (5, 'Peter', 'McTavish', 'Fair@Way,com', '6085552765');
INSERT IGNORE INTO students VALUES (6, 'Jean', 'Coleman', 'Lake@St.com', '6085552654');
INSERT IGNORE INTO students VALUES (7, 'Jeff', 'Black', 'Oak@Blvd.org', '6085555387');
INSERT IGNORE INTO students VALUES (8, 'Maria', 'Escobito', 'Maple@St.com', '6085557683');
INSERT IGNORE INTO students VALUES (9, 'David', 'Schroeder', 'Blackhawk@Trail.org', '6085559435');
INSERT IGNORE INTO students VALUES (10, 'Carlos', 'Estaban', 'Independence@La.com', '6085555487');

INSERT IGNORE INTO courses VALUES (1, 'cat', 'Thranduil', 'books', 'not done');
INSERT IGNORE INTO courses VALUES (2, 'dog', 'Olorin', 'books', 'done');
INSERT IGNORE INTO courses VALUES (3, 'lizard', 'Curunir', 'food', 'in progress');
INSERT IGNORE INTO courses VALUES (4, 'snake', 'Raiwendil', 'food', 'blocked');
INSERT IGNORE INTO courses VALUES (5, 'bird', 'Lorien', 'housing', 'done');
INSERT IGNORE INTO courses VALUES (6, 'hamster', 'Nienna', 'utilities', 'not done');

INSERT IGNORE INTO notes VALUES (1, 'Leo', '2000-09-07', '1, 1');
INSERT IGNORE INTO notes VALUES (2, 'Basil', '2002-08-06', '6, 2');
INSERT IGNORE INTO notes VALUES (3, 'Rosy', '2001-04-17', '2, 3');
INSERT IGNORE INTO notes VALUES (4, 'Jewel', '2000-03-07', '2, 3');
INSERT IGNORE INTO notes VALUES (5, 'Iggy', '2000-11-30', '3, 4');
INSERT IGNORE INTO notes VALUES (6, 'George', '2000-01-20', '4, 5');
INSERT IGNORE INTO notes VALUES (7, 'Samantha', '1995-09-04', '1, 6');
INSERT IGNORE INTO notes VALUES (8, 'Max', '1995-09-04', '1, 6');
INSERT IGNORE INTO notes VALUES (9, 'Lucky', '1999-08-06', '5, 7');
INSERT IGNORE INTO notes VALUES (10, 'Mulligan', '1997-02-24', '2, 8');
INSERT IGNORE INTO notes VALUES (11, 'Freddy', '2000-03-09', '5, 9');
INSERT IGNORE INTO notes VALUES (12, 'Lucky', '2000-06-24', '2, 10');
INSERT IGNORE INTO notes VALUES (13, 'Sly', '2002-06-08', '1, 10');

INSERT IGNORE INTO assignments VALUES (1, 'cat', '2000-09-07', 'books', 'not done');
INSERT IGNORE INTO assignments VALUES (2, 'dog', '2001-09-07', 'books', 'done');
INSERT IGNORE INTO assignments VALUES (3, 'lizard', '2000-09-07', 'food', 'in progress');
INSERT IGNORE INTO assignments VALUES (4, 'snake', '2000-09-07', 'food', 'blocked');
INSERT IGNORE INTO assignments VALUES (5, 'bird', '2000-09-07', 'housing', 'done');
INSERT IGNORE INTO assignments VALUES (6, 'hamster', '2000-09-07', 'utilities', 'not done');

INSERT IGNORE INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (3, 8, '2009-06-04', 'neutered');
INSERT IGNORE INTO visits VALUES (4, 7, '2008-09-04', 'spayed');
