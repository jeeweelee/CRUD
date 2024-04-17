package com.mycompany.dean;


import org.springframework.data.repository.CrudRepository;

public interface DeanRepository extends CrudRepository<Dean, Integer> {
    Long countById(Integer id);
}
