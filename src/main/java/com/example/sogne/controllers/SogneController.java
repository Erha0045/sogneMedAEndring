package com.example.sogne.controllers;

import com.example.sogne.model.Sogne;
import com.example.sogne.repository.SogneRepository;
import com.example.sogne.service.SogneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SogneController {

//    @Autowired
//    SogneRepository sogneRepository;

    private SogneRepository sogneRepository;

    public SogneController(SogneRepository sogneRepository) {
        this.sogneRepository = sogneRepository;
    }

    // HTTP Get List
    @GetMapping("/sogne")
    public ResponseEntity<List<Sogne>> findAll(){
        //findAll recipes and return
        List<Sogne> sogneList = new ArrayList<>();
        for (Sogne sogne:sogneRepository.findAll()){
            sogneList.add(sogne);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sogneList);
    }

    // HTTP Get by ID
    @GetMapping("/sogne/{id}")
    public ResponseEntity<Optional<Sogne>> findById(@PathVariable int id)
    {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (optionalSogne.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogne);
        }
        else{
            //Not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogne);
        }
    }

    // HTTP Post, ie. create
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/sogne", consumes = "application/json")
    public ResponseEntity<Sogne> create(@RequestBody Sogne sogne) {
        Sogne newSogne = sogneRepository.save(sogne);
        //insert location in response header
        return ResponseEntity.ok(newSogne);
    }

    //HTTP PUT, ie. update
    @PutMapping("/sogne/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Sogne sogne) {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()) {
            //id findes ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogne " + id + " not found'}");
        }
        sogneRepository.save(sogne);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");

    }

    //HTTP DELETE
    @DeleteMapping("/sogne/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()) {
            //id findes ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogne " + id + " not found'}");
        }
        sogneRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }


}
