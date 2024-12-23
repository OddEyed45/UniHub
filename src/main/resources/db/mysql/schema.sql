CREATE TABLE IF NOT EXISTS vets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (vet_id,specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS students (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(255),
  telephone VARCHAR(20),
  courses_id INT(4) UNSIGNED,
  notes_id INT(4) UNSIGNED,
  assignments_id INT(4) UNSIGNED,
  INDEX(last_name)
  FOREIGN KEY (courses_id) REFERENCES courses(id),
  FOREIGN KEY (notes_id) REFERENCES notes(id),
  FOREIGN KEY (assignments_id) REFERENCES assignments(id),
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS courses (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  professor VARCHAR(30),
  location VARCHAR(30),
  time VARCHAR(30),
  INDEX(name),
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS notes (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(80),
  date DATE,
  notes VARCHAR(500),
  INDEX(name)
  ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS assignments (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  duedate DATE,
  category VARCHAR(80),
  status VARCHAR(80),
  INDEX(name)
  ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  courses_id INT(4) UNSIGNED,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (courses_id) REFERENCES courses(id)
) engine=InnoDB;
