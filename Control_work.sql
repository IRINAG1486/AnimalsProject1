/*
Cоздать базу данных “Друзья человека”
*/
DROP DATABASE IF EXISTS Humans_friends;
CREATE DATABASE Humans_friends;
USE Humans_friends;

/*
Создать таблицы с иерархией из диаграммы в БД
*/

CREATE TABLE IF NOT EXISTS dogs(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS cats(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS hamsters(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS horses(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS camels(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS donkeys(
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE
);

/*
Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
*/

INSERT INTO dogs (name, commands, date_of_birth)
VALUES ('Bob', 'sit', '2021-07-14'), ('Beil', 'lie', '2022-01-12'), ('Cesar', 'vois', '2020-06-06');

INSERT INTO cats (name, commands, date_of_birth)
VALUES ('Misha', 'lie', '2015-03-03'), ('Varya', 'voise', '2016-05-05'), ('Rada', 'vois', '2019-09-02');

INSERT INTO hamsters (name, commands, date_of_birth)
VALUES ('Rich', 'eat', '2021-08-08'), ('Oscar', 'eat', '2021-08-08'), ('Lola', 'eat', '2022-05-06');

INSERT INTO horses (name, commands, date_of_birth)
VALUES ('Rose', 'step', '2021-07-14'), ('Bella', 'step', '2022-01-12'), ('Dakota', 'trot', '2020-06-06');

INSERT INTO camels (name, commands, date_of_birth)
VALUES ('Otis', 'stop', '2021-07-14'), ('Miki', 'stop', '2022-01-12'), ('Chip', 'stop', '2020-06-06');

INSERT INTO donkeys (name, commands, date_of_birth)
VALUES ('Toto', 'step', '2021-07-14'), ('Loki', 'step', '2022-01-12'), ('Charli', 'step', '2020-06-06');

SELECT * FROM dogs
UNION
SELECT * FROM cats
UNION
SELECT * FROM hamsters
UNION
SELECT * FROM horses
UNION
SELECT * FROM camels
UNION
SELECT * FROM donkeys;

/*
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
*/

TRUNCATE camels;
SELECT * FROM camels;

SELECT *
FROM horses
UNION
SELECT *
FROM donkeys
AS horses_and_donkeys;

/*
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/

CREATE TABLE IF NOT EXISTS young_animals(
  id INT PRIMARY KEY AUTO_INCREMENT,
  animal_name VARCHAR(45),
  animal_commands VARCHAR(45),
  animal_birth DATE,
  animal_age TEXT
);
  
DELIMITER //
SELECT VERSION()//
DROP FUNCTION IF EXISTS get_age//
CREATE FUNCTION get_age(date_birth DATE)
RETURNS TEXT DETERMINISTIC
BEGIN
  DECLARE result TEXT DEFAULT ' ';
  SET result = CONCAT (TIMESTAMPDIFF(YEAR, date_birth, CURDATE()), ' years ', TIMESTAMPDIFF(MONTH, date_birth, CURDATE()) % 12, ' month ');
  RETURN result;
END//
DELIMITER ;

INSERT INTO young_animals (animal_name, animal_commands, animal_birth, animal_age)
SELECT name, commands, date_of_birth, get_age(date_of_birth)
FROM dogs
WHERE timestampdiff(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL 
SELECT name, commands, date_of_birth, get_age(date_of_birth)
FROM cats
WHERE timestampdiff(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL 
SELECT name, commands, date_of_birth, get_age(date_of_birth)
FROM hamsters
WHERE timestampdiff(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL 
SELECT name, commands, date_of_birth, get_age(date_of_birth)
FROM horses
WHERE timestampdiff(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL 
SELECT name, commands, date_of_birth, get_age(date_of_birth)
FROM donkeys
WHERE timestampdiff(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

SELECT * FROM young_animals;

/*
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/
CREATE TABLE IF NOT EXISTS all_animals(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name_of_animal VARCHAR (45),
  commands VARCHAR (45),
  date_of_birth DATE,
  age TEXT,
  animal_type ENUM('dogs', 'cats', 'hamsters', 'horses', 'donkeys')
  );
  
  INSERT INTO all_animals( name_of_animal, commands, date_of_birth, age, animal_type)
  SELECT  name, commands, date_of_birth, get_age(date_of_birth), 'dogs'
  FROM dogs;
  
  INSERT INTO all_animals( name_of_animal, commands, date_of_birth, age, animal_type)
  SELECT  name, commands, date_of_birth, get_age(date_of_birth), 'cats'
  FROM cats;
  
  INSERT INTO all_animals( name_of_animal, commands, date_of_birth, age, animal_type)
  SELECT  name, commands, date_of_birth, get_age(date_of_birth), 'hamsters'
  FROM hamsters;
  
  INSERT INTO all_animals( name_of_animal, commands, date_of_birth, age, animal_type)
  SELECT  name, commands, date_of_birth, get_age(date_of_birth), 'horses'
  FROM horses;
  
  INSERT INTO all_animals( name_of_animal, commands, date_of_birth, age, animal_type)
  SELECT  name, commands, date_of_birth, get_age(date_of_birth), 'donkeys'
  FROM donkeys;
  
  SELECT * FROM all_animals;
  
  