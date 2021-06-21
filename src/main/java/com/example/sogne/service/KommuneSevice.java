package com.example.sogne.service;

import com.example.sogne.model.Kommune;
import com.example.sogne.model.Sogne;
import com.example.sogne.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class KommuneSevice {
    @Autowired
    KommuneRepository kommuneRepository;

    public Set<Kommune> findAll(){
        Set<Kommune> kommuneSet = new HashSet<>();
        for (Kommune kommune: kommuneRepository.findAll()){
            kommuneSet.add(kommune);
        }
        return kommuneSet;
    }

    public Kommune findById(Integer id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (!optionalKommune.isPresent()){
            throw new RuntimeException("Kommune " + id + " not found");
        }
        //returner indhold af optional vha. get()
        return optionalKommune.get();
    }
    public Kommune create(Kommune kommune){
        return kommuneRepository.save(kommune);
    }

    public Kommune update(Kommune kommune){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return kommuneRepository.save(kommune);
    }

    public void deleteById(int id){
        kommuneRepository.deleteById(id);
    }

}
