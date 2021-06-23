package com.example.sogne.controllers;

import com.example.sogne.model.Kommune;
import com.example.sogne.model.Sogne;
import com.example.sogne.service.KommuneSevice;
import com.example.sogne.service.SogneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HomeController {
@Autowired
    SogneService sogneService;

@Autowired
    KommuneSevice kommuneSevice;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Sogne> sogneSet;
        sogneSet=sogneService.findAll();
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
        sogneService.create(sogne);
        return "redirect:/";

    }

    @GetMapping("/delete")
    public String delete(){
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id")int id) {
        sogneService.deleteById(id);
        return  "redirect:/";
    }

    @GetMapping("/update")
    public String updateSogn(){
        return "/update";
    }
//    @GetMapping("/update/{id}")
//    public String updateSogn(@PathVariable(value = "id") int id, Model model) {
//        // Get Sogn from the service
//        Sogne sogn = sogneService.findById(id);
//
//        // Set Sogn as a model attribute
//        model.addAttribute("sogn", sogn);
//        return "update_sogn";
//    }


    @PostMapping("/update")
    public String updateSogn(
            @RequestParam("id") int id,
            @RequestParam("sognekode") int sognekode,
            @RequestParam("navn") String navn,
            @RequestParam("smittetryk") double smittetryk,
            @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
            @RequestParam("kommune")Kommune kommune){
        Sogne sogne = new Sogne(id, sognekode, navn, smittetryk, nedlukningStart,kommune );
        sogneService.update(sogne);
        return "redirect:/";

    }
}
