package com.mycompany.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProfessorController {

    private static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    private ProfessorService service;

    @GetMapping("/professors")
    public String showProfessorList(Model model) {
        List<Professor> listProfessors = service.listAll();
        model.addAttribute("listProfessors", listProfessors);
        return "professors";
    }

    @GetMapping("/professors/new")
    public String showNewForm(Model model) {
        model.addAttribute("professor", new Professor());
        model.addAttribute("pageTitle", "Add New Professor");
        return "professor_form";
    }

    @PostMapping("/professors/save")
    public String saveProfessor(Professor professor, RedirectAttributes ra) throws Exception {
        try {
            service.save(professor);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        ra.addFlashAttribute("message", "The professor has been saved successfully.");
        return "redirect:/professors";
    }

    @GetMapping("/professors/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Professor professor = service.get(id);
            model.addAttribute("professor", professor);
            model.addAttribute("pageTitle", "Edit Professor (ID:" + id + ")");
            return "professor_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/professors";
        }
    }

    @GetMapping("/professors/delete/{id}")
    public String deleteProfessor(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The professor Id " + id + " has been deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/professors";
    }

}

