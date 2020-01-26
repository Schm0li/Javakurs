package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class NameService {
    private static NameRepository nameRepository;

    public NameService(NameRepository nameRepository){
        NameService.nameRepository = nameRepository;
    }

    public void addName(Name name){
        nameRepository.save(name);
    }

    public ArrayList<Name> findAll(){
        return nameRepository.findAll();
    }
}
