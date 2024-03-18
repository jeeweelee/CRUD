package com.mycompany.professor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {


    @Autowired
    private ProfessorRepository repo;

    public List<Professor> listAll() {
        return (List<Professor>) repo.findAll();
    }

    public Object save(Professor professor) {
        repo.save(professor);
        return null;
    }

    public Professor get(Integer id) throws Exception {
        Optional<Professor> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any professor with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any professor with Id" + id);
        }
        repo.deleteById(id);
    }
}
