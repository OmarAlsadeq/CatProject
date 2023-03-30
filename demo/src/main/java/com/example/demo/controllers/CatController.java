package com.example.demo.controllers;

import com.example.demo.data.CatRepository;

import com.example.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("create")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    private static List<Cat> cats = new ArrayList<>();

    @PostMapping("create")
    public String processCatForm(@RequestParam String catName){
     cats.add(new Cat(catName));
     return "redirect:";
    }
}
