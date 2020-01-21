package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Name {
    private @Id String name;

    @SuppressWarnings("unused")
    private Name(){}

    public Name(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
