package com.mycompany;

import com.mycompany.student.Student;
import com.mycompany.student.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryTests {
    @Autowired private StudentRepository repo;

    @Test
    public void testAddNew(){
        Student student = new Student();
        student.setEmail("Buh321@gmail.com");
        student.setPassword("wefw");
        student.setFirstName("Jacky");
        student.setLastName("Wa");

        Student savedStudent = repo.save(student);

        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<Student> students1 = repo.findAll();
        Assertions.assertThat(students1).hasSizeGreaterThan(0);


        for(Student studentsvariable : students1){
            System.out.println(studentsvariable);
        }
    }
    @Test
    public void testUpdate(){
        Integer studentId = 2;
        Optional<Student> optionalStudent = repo.findById(studentId);
        Student student = optionalStudent.get();
        student.setPassword("dsadas");
        repo.save(student);

        Student updatedStudent = repo.findById(studentId).get();
        Assertions.assertThat(updatedStudent.getPassword()).isEqualTo("gfdgdf");
    }
    @Test
    public void testGet(){
        Integer studentId = 2;
        Optional<Student> optionalStudent = repo.findById(studentId);
        Student student = optionalStudent.get();

        Assertions.assertThat(optionalStudent).isPresent();
        System.out.println(optionalStudent.get());

    }
    @Test
    public void testDelete() {
        Integer studentId = 2;
        repo.deleteById(studentId);

        Optional<Student> optionalStudent = repo.findById(studentId);
        Assertions.assertThat(optionalStudent).isNotPresent();
    }
}
