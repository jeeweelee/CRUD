package com.mycompany.department;


import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Long countById(Integer id);
}
