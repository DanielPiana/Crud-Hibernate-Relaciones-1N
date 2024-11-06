DROP DATABASE IF EXISTS Taller;
CREATE DATABASE Taller;
USE Taller;

CREATE TABLE coches (
  Id int unsigned auto_increment primary key,
  matricula varchar(50) DEFAULT NULL,
  marca varchar(50) DEFAULT NULL,
  modelo varchar(50) DEFAULT NULL,
  tipo enum('Familiar','Monovolumen','Deportivo','SUV')
)  ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

INSERT INTO coches VALUES
(1,"1122BBC","Renault","Clio","Familiar"),
(2,"2233DDB","Seat","Ibiza","Familiar"),
(3,"3344FFC","Seat","Leon","Deportivo"),
(4,"4455BBZ","Ford","S-Max","Monovolumen"),
(5,"5566CCR","Ford","Kuga","SUV"),
(6,"6677FFD","Nisan","Micra","Familiar"),
(7,"7788JJZ","Volkswagen","Pasat","Familiar"),
(8,"8899BBV","Volkswagen","T-ROC","SUV"),
(9,"9911FFG","Volkswagen","Touran","Monovolumen"),
(10,"8855GFR","Renault","Scenic","Monovolumen");


CREATE TABLE multas (
  id_multa integer unsigned NOT NULL AUTO_INCREMENT,
  id_coche integer,
  precio DOUBLE NOT NULL,
  fecha DATE DEFAULT NULL,
  matricula varchar(7) NOT NULL,
  PRIMARY KEY (id_multa)
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;


INSERT INTO Multas (id_coche, matricula, precio, fecha)
VALUES (1,'1122BBC', 200, '2023-12-12'),
       (1,'1122BBC', 700, '2023-12-13'),
       (2,'1234AAA', 50, '2023-12-14'),
       (1,'1122BBC', 250, '2024-12-01'),
        (3,'3344FFC', 100, '2024-11-21');
