package com.example.demo.controllers;


import com.example.demo.data.CatData;
import com.example.demo.data.CatRepository;
import com.example.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
//page lives at /cats
@RequestMapping("cats")
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public String displayAllCats(Model model){
        model.addAttribute("title","All Cats");
        model.addAttribute("cats", CatData.getAll());
        return "cats/index";
    }

    @GetMapping("create")
    public String renderCreateCatForm(Model model){
        model.addAttribute("title", "Create Cat");
        model.addAttribute(new Cat());
        return "cats/create";
    }

    @PostMapping("create")
    public String CreateCat(@ModelAttribute @Valid Cat newCat,
                            Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Cat");
            return "cats/create";
        }

        CatData.add(newCat);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteCatForm(Model model){
        model.addAttribute("title", "Delete Cats");
        model.addAttribute("cats", CatData.getAll());
        return "cats/delete";
    }

    @PostMapping("delete")
    public String processDeleteCatForm(@RequestParam(required = false) int[] catIds){
        if(catIds != null) {
            for (int id : catIds) {
                CatData.remove(id);
            }
        }
        return "redirect:";
    }
    @GetMapping("edit/{id}")
    public String displayEditForm(Model model, @PathVariable int id) {
        Cat catToEdit = CatData.getById(id);
        model.addAttribute("cat", catToEdit);
        String title = "Edit Cat " + catToEdit.getCatName() + "(id= " + catToEdit.getId() + ")";
        model.addAttribute("title", title);
        return "cats/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int catId, String catName, String catAge, String catSex, String catFixed, String catBreed, String catColor, String catEars, String catTail, String catClaw, String catLocation, String catLost, String catChip, String catDescription) {
        Cat catToEdit = CatData.getById(catId);
        catToEdit.setCatName(catName);
        catToEdit.setCatAge(catAge);
        catToEdit.setCatSex(catSex);
        catToEdit.setCatFixed(catFixed);
        catToEdit.setCatBreed(catBreed);
        catToEdit.setCatColor(catColor);
        catToEdit.setCatEars(catEars);
        catToEdit.setCatTail(catTail);
        catToEdit.setCatClaw(catClaw);
        catToEdit.setCatLocation(catLocation);
        catToEdit.setCatLost(catLost);
        catToEdit.setCatChip(catChip);
        catToEdit.setCatDescription(catDescription);
        return "redirect:";
    }
}
