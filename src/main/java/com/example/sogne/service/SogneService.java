package com.example.sogne.service;

import com.example.sogne.model.Sogne;
import com.example.sogne.repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SogneService {
    @Autowired
    SogneRepository sogneRepository;

    public Set<Sogne> findAll(){
        Set<Sogne> sogneSet = new HashSet<>();
        for (Sogne sogne:sogneRepository.findAll()){
            sogneSet.add(sogne);
        }
        return sogneSet;
    }

    public Sogne findById(Integer id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()){
            throw new RuntimeException("Sogne " + id + " not found");
        }
        //returner indhold af optional vha. get()
        return optionalSogne.get();
    }
    public Sogne create(Sogne sogne){
        return sogneRepository.save(sogne);
    }

    public Sogne update(Sogne sogne){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return sogneRepository.save(sogne);
    }

    public void deleteById(int id){
        sogneRepository.deleteById(id);
    }




}
