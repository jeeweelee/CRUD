CREATE TABLE STUDENT (
Student_Id SMALLINT NOT NULL AUTO_INCREMENT,
Email VARCHAR(45) NOT NULL,
Password VARCHAR(15) NOT NULL,
First_Name VARCHAR(45) NOT NULL,
Last_Name VARCHAR(45) NOT NULL,
Date_Of_Birth TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
Class_Id SMALLINT NOT NULL,
Course_Id SMALLINT NOT NULL,
PRIMARY KEY (Student_Id),
CONSTRAINT fkClassId FOREIGN KEY (Class_Id) REFERENCES Classes (Class_Id) ON DELETE RESTRICT ON UPDATE CASCADE,
CONSTRAINT fkCourseId FOREIGN KEY (Course_Id) REFERENCES Course (Course_Id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;