package com.mycompany.dean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DeanService {


    @Autowired
    private DeanRepository repo;

    public List<Dean> listAll() {
        return (List<Dean>) repo.findAll();
    }

    public Object save(Dean dean) {
        repo.save(dean);
        return null;
    }

    public Dean get(Integer id) throws Exception {
        Optional<Dean> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any dean with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any dean with Id" + id);
        }
        repo.deleteById(id);
    }
}
