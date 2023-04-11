package com.example.demo.controllers;


import com.example.demo.model.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
//page lives at /cats
@RequestMapping("cats")
public class CatController {

    private final static List<Cat> cats = new ArrayList<>();


    @GetMapping
    public String displayAllCats(Model model){
        model.addAttribute("title","All Cats");
        model.addAttribute("cats", cats);
        return "cats/index";
    }

    @GetMapping("create")
    public String renderCreateCatForm(Model model){
        model.addAttribute("title", "Create Cat");
        return "cats/create";
    }

    @PostMapping("create")
    public String CreateCat(@RequestParam String catName,
                            /*@RequestParam String catDate,*/
                            @RequestParam String catSex,
                            @RequestParam String catFixed,
                            @RequestParam String catAge,
                            @RequestParam String catBreed,
                            @RequestParam String catColor,
                            @RequestParam String catEars,
                            @RequestParam String catTail,
                            @RequestParam String catClaw,
                            @RequestParam String catLocation,
                            @RequestParam String catLost,
                            @RequestParam String catCollar,
                            @RequestParam String catChip,
                            @RequestParam String catDescription
                           /* @RequestParam String catPic*/){
        cats.add(new Cat(catName,/*, catDate, */catSex, catFixed, catAge, catBreed, catColor, catEars, catTail, catClaw, catLocation, catLost, catCollar, catChip, catDescription/*, catPic*/));
        return "redirect:";
    }
}
