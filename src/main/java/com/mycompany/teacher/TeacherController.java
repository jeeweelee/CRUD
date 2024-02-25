package com.mycompany.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/teachers")
    public String showTeacherList(Model model) {
        List<Teacher> listTeachers = service.listAll();
        model.addAttribute("listTeachers", listTeachers);
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String showNewForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("pageTitle", "Add New Teacher");
        return "teacher_form";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(Teacher teacher, RedirectAttributes ra) {
        service.save(teacher);
        ra.addFlashAttribute("message", "The teacher has been saved successfully.");
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Teacher teacher = service.get(id);
            model.addAttribute("teacher", teacher);
            model.addAttribute("pageTitle", "Edit Teacher (ID:" + id + ")");
            return "teacher_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/teachers";
        }
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The teacher Id " + id + " has been deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/teachers";
    }

}

