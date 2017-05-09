package org.itis.portal.controller;

import org.itis.portal.entity.Laboratory;
import org.itis.portal.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("laboratories", laboratoryRepository.findAll());
        return "laboratory/laboratories";
    }

    @GetMapping("/{laboratory}")
    public String show(@PathVariable Laboratory laboratory, ModelMap modelMap) {
        if (laboratory == null) {
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("LC#index").build();
        }
        modelMap.addAttribute("laboratory", laboratory);
        return "laboratory/laboratory";
    }

    @GetMapping("/new")
    public String newLaboratory(ModelMap modelMap) {
        modelMap.addAttribute("laboratory", new Laboratory());
        return "laboratory/new";
    }

    @PostMapping
    public String create(
            RedirectAttributes redirectAttributes,
            @Validated Laboratory laboratory,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "laboratory/new";
        } else {
            this.laboratoryRepository.save(laboratory);
            redirectAttributes.addFlashAttribute("message", "Book \"" + laboratory.getName() + "\" has been saved successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("LC#newLaboratory").build();
        }
    }
    @GetMapping("/edit/{laboratory}")
    public String edit(@PathVariable Laboratory laboratory, ModelMap modelMap) {
        if (laboratory == null) {
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("LC#index").build();
        }
        modelMap.addAttribute("laboratory", laboratory);
        return "laboratory/edit";
    }

    @PostMapping("/edit")
    public String update(
            RedirectAttributes redirectAttributes,
            @Validated Laboratory laboratory,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "laboratory/edit";
        } else {
            this.laboratoryRepository.save(laboratory);
            redirectAttributes.addFlashAttribute("message", "Book \"" + laboratory.getName() + "\" has been saved successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("LC#show").arg(0, laboratory).build();
        }
    }

    @DeleteMapping("/delete/{laboratory}")
    public String delete(@PathVariable Laboratory laboratory, RedirectAttributes redirectAttributes) {
        try {
            this.laboratoryRepository.delete(laboratory);
            redirectAttributes.addFlashAttribute("message", "Laboratory has been deleted successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
        }catch (DataAccessException e) {
            redirectAttributes.addFlashAttribute("message", "Can't delete laboratory.");
            redirectAttributes.addFlashAttribute("messageType", "fail");
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("LC#index").build();
    }

}
