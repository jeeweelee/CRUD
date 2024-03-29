package com.mycompany.courses;


import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Long countById(Integer id);
}
