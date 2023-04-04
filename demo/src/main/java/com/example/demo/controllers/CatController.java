package com.example.demo.controllers;

import com.example.demo.data.CatRepository;

import com.example.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping
    public String displayAllCats(Model model){
        List<String> cats = new ArrayList<>();
        cats.add("Calico");
        cats.add("Ginger");
        cats.add("TortoiseShell");
        cats.add("Siamese");
        model.addAttribute("cats", cats);
        return "cats/index";
    }

    @GetMapping("create")
    public String renderCreateCatForm(){
        return "cats/create";
    }
}
