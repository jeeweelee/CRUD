package com.mycompany.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {


    @Autowired
    private StudentRepository repo;

    public List<Student> listAll() {
        return (List<Student>) repo.findAll();
    }

    public Object save(Student student) {
        repo.save(student);
        return null;
    }

    public Student get(Integer id) throws Exception {
        Optional<Student> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any students with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any students with Id" + id);
        }
        repo.deleteById(id);
    }
}
