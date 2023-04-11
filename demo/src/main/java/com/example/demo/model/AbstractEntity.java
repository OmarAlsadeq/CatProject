package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    private static int nextId = 1;

    public AbstractEntity(){
        this.id=nextId;
        nextId++;
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

    @Override public int hashCode(){
        return Objects.hash(id);
    }
}
