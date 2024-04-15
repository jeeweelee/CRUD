package com.mycompany.dao;

import com.mycompany.dean.Dean;
import com.mycompany.dean.DeanRepository;
import com.mycompany.department.Department;
import com.mycompany.department.DepartmentRepository;
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
    private ProfessorRepository professorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void run(String... args) throws Exception {

        addDataToDepartmentTable(5);
        addDataToDeanTable(5);


//
//        Department department = new Department();
//        department.setId(1);
//        department.setDepartment_location("TEST_LOCATION");
//        department.setDepartment_name("TEST_NAME");
//
//        Dean dean = new Dean(); // Set properties for department if needed
//        dean.setId(1);
//        dean.setEmail(emailStr);
//        dean.setPassword(passwordStr);
//        dean.setFirstName(firstNameStr);
//        dean.setLastName(lastNameStr);
//        dean.setEnabled(true);
//
//        Professor professor = new Professor();
//        professor.setEmail(emailStr);
//        professor.setPassword(passwordStr);
//        professor.setFirstName(firstNameStr);
//        professor.setLastName(lastNameStr);
//        professor.setEnabled(true);
//        professor.setDepartment(department); // Ensure this department is persisted or retrieved from DB
//        professor.setDean(dean);
//
//        professorRepository.save(professor);
    }

    private void addDataToDepartmentTable(int numOfRecordsToInsert) {


        for (int i = 0; i < numOfRecordsToInsert; i++) {
            Department department = new Department();
            department.setId(numOfRecordsToInsert);
            department.setDepartment_location("TEST_LOCATION");
            department.setDepartment_name("TEST_NAME");
            departmentRepository.save(department);
        }


    }


    private void addDataToDeanTable(int numOfRecordsToInsert) {


        for (int i = 0; i < numOfRecordsToInsert; i++) {

            String email = "example_" + i + "@pace.edu";

            Dean dean = new Dean();
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
