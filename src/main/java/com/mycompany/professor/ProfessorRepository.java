package com.mycompany.professor;


import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    Long countById(Integer id);
}
