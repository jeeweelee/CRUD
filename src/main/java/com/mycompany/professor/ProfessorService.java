package com.mycompany.professor;


import com.mycompany.classes.ClassRepository;
import com.mycompany.dean.DeanRepository;
import com.mycompany.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private DeanRepository deanRepository;

    public List<Professor> listAll() {
        return (List<Professor>) professorRepository.findAll();
    }

//    public Object save(Professor professor) {
//        repo.save(professor);
//        return null;
//    }

    public Professor save(Professor professor) throws Exception {

        if (departmentRepository.findById(professor.getDepartment().getId()).isEmpty()) {
            throw new Exception("Department not found for ID: " + professor.getDepartment().getId());
        }

        if (classRepository.findById(professor.getClasses().getId()).isEmpty()) {
            throw new Exception("Class not found for ID: " + professor.getClasses().getId());
        }

        if (deanRepository.findById(professor.getDean().getId()).isEmpty()) {
            throw new Exception("Dean not found for ID: " + professor.getDean().getId());
        }

        professorRepository.save(professor);
        return professor;
    }

    public Professor get(Integer id) throws Exception {
        Optional<Professor> result = professorRepository.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new Exception("Could not find any professor with Id" + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = professorRepository.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any professor with Id" + id);
        }
        professorRepository.deleteById(id);
    }
}
