package com.mycompany.teacher;


import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Long countById(Integer id);
}
