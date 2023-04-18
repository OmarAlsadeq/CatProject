package com.example.demo.data;

import com.example.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CatData {
    

    //place to put cats
    private static final Map<Integer, Cat> cats = new HashMap<>();

    //get all cats
    public static Collection<Cat> getAll(){
        return cats.values();
    }
    //get a single cat
    public static Cat getById(int id){
        return cats.get(id);
    }

    //add a cat
    public static void add(Cat cat){
        cats.put(cat.getId(), cat);
    }
    //remove a cat
    public static void remove(int id){
        cats.remove(id);
    }

}
