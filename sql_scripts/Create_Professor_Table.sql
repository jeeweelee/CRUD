CREATE TABLE PROFESSOR (
Professor_Id SMALLINT NOT NULL AUTO_INCREMENT,
Email VARCHAR(45) NOT NULL,
Password VARCHAR(15) NOT NULL,
First_Name VARCHAR(45) NOT NULL,
Last_Name VARCHAR(45) NOT NULL,
Date_Of_Birth TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
Department_Id SMALLINT NOT NULL,
Class_Id SMALLINT NOT NULL,
PRIMARY KEY (Professor_Id),
CONSTRAINT fkDepartment_Id FOREIGN KEY (Department_Id) REFERENCES Department (Department_Id) ON DELETE RESTRICT ON UPDATE CASCADE,
CONSTRAINT fkClass_Id FOREIGN KEY (Class_Id) REFERENCES Classes (Class_Id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;