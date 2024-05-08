package com.mycompany.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService service;

    @GetMapping("/classes")
    public String showClassesList(Model model) {
        List<Classes> listClasses = service.listAll();
        model.addAttribute("listClasses", listClasses);
        return "classes";
    }

    @GetMapping("/classes/new")
    public String showNewForm(Model model) {
        model.addAttribute("class", new Classes());
        model.addAttribute("pageTitle", "Add New Classes");
        return "classes_form";
    }

    @PostMapping("/classes/save")
    public String saveClasses(Classes classes, RedirectAttributes ra) {
        classes.fixSubject();
        classes.setDescription();
        service.save(classes);
        ra.addFlashAttribute("message", "The classes has been saved successfully.");
        return "redirect:/classes";
    }

    @GetMapping("/classes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Classes classes = service.get(id);
            model.addAttribute("classes", classes);
            model.addAttribute("pageTitle", "Edit Classes (ID:" + id + ")");
            return "classes_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/classes";
        }
    }

    @GetMapping("/classes/delete/{id}")
    public String deleteClasses(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The classes Id " + id + " has been deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/classes";
    }

}

