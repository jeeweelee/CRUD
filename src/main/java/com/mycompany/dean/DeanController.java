package com.mycompany.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DeanController {
    @Autowired
    private DeanService service;

    @GetMapping("/deans")
    public String showDeanList(Model model) {
        List<Dean> listDeans = service.listAll();
        model.addAttribute("listDeans", listDeans);
        return "deans";
    }

    @GetMapping("/deans/new")
    public String showNewForm(Model model) {
        model.addAttribute("dean", new Dean());
        model.addAttribute("pageTitle", "Add New Dean");
        return "dean_form";
    }

    @PostMapping("/deans/save")
    public String saveDean(Dean dean, RedirectAttributes ra) {
        service.save(dean);
        ra.addFlashAttribute("message", "The dean has been saved successfully.");
        return "redirect:/deans";
    }

    @GetMapping("/deans/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Dean dean = service.get(id);
            model.addAttribute("dean", dean);
            model.addAttribute("pageTitle", "Edit Dean (ID:" + id + ")");
            return "dean_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/deans";
        }
    }

    @GetMapping("/deans/delete/{id}")
    public String deleteDean(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The dean Id " + id + " has been deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/deans";
    }

}

