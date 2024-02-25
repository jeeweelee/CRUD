package com.mycompany.teacher;


import com.mycompany.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeacherService {


    @Autowired
    private TeacherRepository repo;

    public List<Teacher> listAll() {
        return (List<Teacher>) repo.findAll();
    }

    public Object save(Teacher teacher) {
        repo.save(teacher);
        return null;
    }

    public Teacher get(Integer id) throws Exception {
        Optional<Teacher> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any teacher with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any teacher with Id" + id);
        }
        repo.deleteById(id);
    }
}
