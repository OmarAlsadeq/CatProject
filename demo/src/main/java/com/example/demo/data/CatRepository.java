package com.example.demo.data;

import com.example.demo.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface CatRepository extends CrudRepository<Cat, Integer> {
    Cat findById(int id);
}
