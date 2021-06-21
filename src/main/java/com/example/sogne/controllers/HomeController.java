package com.example.sogne.controllers;

import com.example.sogne.model.Kommune;
import com.example.sogne.model.Sogne;
import com.example.sogne.repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
@Autowired
SogneRepository sogneRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Sogne> sogneSet;
        sogneSet=sogneRepository.findAll();
        model.addAttribute("sogneSet",sogneSet);
        return "index";
    }

    @GetMapping("/createSogn")
    public String createSogn(){
        return "/createSogn";
    }



    @PostMapping("/create")
    public String createNewProject(
            @RequestParam("sognekode") int sognekode,
            @RequestParam("navn") String navn,
            @RequestParam("smittetryk") double smittetryk,

            @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
            @RequestParam("kommune")Kommune kommune){
        Sogne sogne = new Sogne(sognekode, navn, smittetryk, nedlukningStart,kommune );
        sogneRepository.save(sogne);
        return "redirect:/";

    }

    @GetMapping("/delete")
    public String delete(){
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id")int id) {
        sogneRepository.deleteById(id);
        return  "redirect:/";
    }


    @GetMapping("/update")
    public String updateSogn(){
        return "/update";
    }
    @PostMapping("/update")
    public String updateSogn(
            @RequestParam("id") int id,
            @RequestParam("sognekode") int sognekode,
            @RequestParam("navn") String navn,
            @RequestParam("smittetryk") double smittetryk,
            @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
            @RequestParam("kommune")Kommune kommune){
        Sogne sogne = new Sogne(id, sognekode, navn, smittetryk, nedlukningStart,kommune );
        sogneRepository.save(sogne);
        return "redirect:/";

    }
}
