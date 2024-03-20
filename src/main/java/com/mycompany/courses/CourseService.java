package com.mycompany.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService {


    @Autowired
    private CourseRepository repo;

    public List<Course> listAll() {
        return (List<Course>) repo.findAll();
    }

    public Object save(Course course) {
        repo.save(course);
        return null;
    }

    public Course get(Integer id) throws Exception {
        Optional<Course> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any course with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any course with Id" + id);
        }
        repo.deleteById(id);
    }
}
