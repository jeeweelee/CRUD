package com.mycompany.dao;

import com.mycompany.classes.ClassRepository;
import com.mycompany.classes.Classes;
import com.mycompany.dean.Dean;
import com.mycompany.dean.DeanRepository;
import com.mycompany.department.Department;
import com.mycompany.department.DepartmentRepository;
import com.mycompany.professor.Professor;
import com.mycompany.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataPreloader implements CommandLineRunner {

    private static final String FIRST_NAME_STR = "John";
    private static final String LAST_NAME_STR = "Doe";
    private static final String PASSWORD_STR = "password";

    @Autowired
    private DeanRepository deanRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void run(String... args) throws Exception {

        int numRecords = 5;

        Department department = new Department();
        Dean dean = new Dean();
        Classes classes = new Classes();

        addDataToDepartmentTable(department, numRecords);
        addDataToDeanTable(dean, numRecords);
        addDataToClassesTable(classes, numRecords);


        Professor professor = new Professor();
        professor.setId(1);
        professor.setEmail("example@pace.edu");
        professor.setPassword(PASSWORD_STR);
        professor.setFirstName(FIRST_NAME_STR);
        professor.setLastName(LAST_NAME_STR);
        professor.setEnabled(true);
        professor.setDepartment(department);
        professor.setDean(dean);
        professor.setClasses(classes);

        professorRepository.save(professor);

    }

    private void addDataToDepartmentTable(Department department, int numOfRecordsToInsert) {


        for (int i = 0; i < numOfRecordsToInsert; i++) {
            department.setId(numOfRecordsToInsert);
            department.setDepartment_location("TEST_LOCATION");
            department.setDepartment_name("TEST_NAME");
            departmentRepository.save(department);
        }


    }


    private void addDataToClassesTable(Classes classes, int numOfRecordsToInsert) {

        for (int i = 0; i < numOfRecordsToInsert; i++) {
            classes.setId(i);
            classes.setClass_name("CLASS_NAME");
            classes.setClass_location("CLASS_LOCATION");
            classes.setNum_students(50);
            classRepository.save(classes);
        }


    }


    private void addDataToDeanTable(Dean dean, int numOfRecordsToInsert) {


        for (int i = 0; i < numOfRecordsToInsert; i++) {

            String email = "example_" + i + "@pace.edu";

            dean.setId(i);
            dean.setEmail(email);
            dean.setPassword(PASSWORD_STR);
            dean.setFirstName(FIRST_NAME_STR);
            dean.setLastName(LAST_NAME_STR);
            dean.setEnabled(true);
            deanRepository.save(dean);
        }


    }

}
