package com.mycompany.classes;


import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Classes, Integer> {
    Long countById(Integer id);
}
