package com.mycompany.professor;


import com.mycompany.classes.ClassRepository;
import com.mycompany.classes.Classes;
import com.mycompany.dean.Dean;
import com.mycompany.dean.DeanRepository;
import com.mycompany.department.Department;
import com.mycompany.department.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {

    private static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

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


    public Professor save(Professor professor) throws Exception {

        if (professor.getDepartment() == null) {

            Department department = new Department();
            department.setId(1);
            professor.setDepartment(department);

        }

        if (professor.getClasses() == null) {

            Classes classes = new Classes();
            classes.setId(1);
            professor.setClasses(classes);

        }

        if (professor.getDean() == null) {

            Dean dean = new Dean();
            dean.setId(1);
            professor.setDean(dean);

        }

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
