package com.mycompany.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository repo;

    public List<Department> listAll() {
        return (List<Department>) repo.findAll();
    }

    public Object save(Department department) {
        repo.save(department);
        return null;
    }

    public Department get(Integer id) throws Exception {
        Optional<Department> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any department with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any department with Id" + id);
        }
        repo.deleteById(id);
    }
}
