package com.example.demo.controllers;


import com.example.demo.data.CatRepository;
import com.example.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
//page lives at /cats
@RequestMapping("cats")
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public String displayAllCats(Model model){
        model.addAttribute("title","All Cats");
        model.addAttribute("cats", catRepository.findAll());
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

        catRepository.save(newCat);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteCatForm(Model model){
        model.addAttribute("title", "Delete Cats");
        model.addAttribute("cats", catRepository.findAll());
        return "cats/delete";
    }

    @PostMapping("delete")
    public String processDeleteCatForm(@RequestParam(required = false) int[] catIds) {
        if (catIds != null) {
            for (int id : catIds) {
                catRepository.deleteById(id);
            }
        }
        return "redirect:";
    }


    @GetMapping("edit/{id}")
    public String displayEditForm(Model model, @PathVariable int id) {
        Cat catToEdit = catRepository.findById(id);
        model.addAttribute("cat", catToEdit);
        String title = "Edit Cat " + catToEdit.getCatName() + "(id= " + catToEdit.getId() + ")";
        model.addAttribute("title", title);
        return "cats/edit";
    }
    @PostMapping("edit/{id}")
    public String processEditForm(@PathVariable int id, @ModelAttribute("cats") Cat cat){
        Cat catToEdit = catRepository.findById(id);
        catToEdit.setCatName(cat.getCatName());
        catToEdit.setCatAge(cat.getCatAge());
        catToEdit.setCatSex(cat.getCatSex());
        catToEdit.setCatFixed(cat.getCatFixed());
        catToEdit.setCatBreed(cat.getCatBreed());
        catToEdit.setCatColor(cat.getCatColor());
        catToEdit.setCatEars(cat.getCatEars());
        catToEdit.setCatTail(cat.getCatTail());
        catToEdit.setCatClaw(cat.getCatClaw());
        catToEdit.setCatLocation(cat.getCatLocation());
        catToEdit.setCatLost(cat.getCatLost());
        catToEdit.setCatChip(cat.getCatChip());
        catToEdit.setCatDescription(cat.getCatDescription());
        catToEdit.setLatitude(cat.getLatitude());
        catToEdit.setLongitude(cat.getLongitude());
        catRepository.save(catToEdit);
        return "redirect:";
    }
    @GetMapping("tnr")
    public String showTNRPage(){
        return "cats/tnr";
    }
    @GetMapping("lost")
    public String showlostCatPage(){
        return "cats/lost";
    }
}
