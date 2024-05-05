package com.mycompany.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String showStudentList(Model model) {
        List<Student> listStudents = service.listAll();
        model.addAttribute("listStudents", listStudents);
        return "students";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, RedirectAttributes ra) {
        student.SetClassification();
        service.save(student);
        ra.addFlashAttribute("message", "The student has been saved successfully.");
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Student student = service.get(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student (ID:" + id + ")");
            return "student_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/students";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The student Id " + id + " has been deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/students";
    }

}
