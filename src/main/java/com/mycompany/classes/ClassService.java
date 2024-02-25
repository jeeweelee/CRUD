package com.mycompany.classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClassService {


    @Autowired
    private ClassRepository repo;

    public List<Classes> listAll() {
        return (List<Classes>) repo.findAll();
    }

    public Object save(Classes classes) {
        repo.save(classes);
        return null;
    }

    public Classes get(Integer id) throws Exception {
        Optional<Classes> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any classes with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any classes with Id" + id);
        }
        repo.deleteById(id);
    }
}
