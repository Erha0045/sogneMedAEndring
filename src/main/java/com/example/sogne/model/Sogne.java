package com.example.sogne.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sogne")
public class Sogne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sognekode;
    private String navn;
    private double smittetryk;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nedlukningStart;


    @OneToOne
    @JoinColumn(name = "kommune_id")
    private Kommune kommune;

    public Sogne() {
    }

    public Sogne(int sognekode, String navn, double smittetryk, LocalDate nedlukningStart, Kommune kommune) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
        this.kommune = kommune;
    }

    public Sogne(int id, int sognekode, String navn, double smittetryk, LocalDate nedlukningStart, Kommune kommune) {
        this.id = id;
        this.sognekode = sognekode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
        this.kommune = kommune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSognekode() {
        return sognekode;
    }

    public void setSognekode(int sognekode) {
        this.sognekode = sognekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(double smittetryk) {
        this.smittetryk = smittetryk;
    }

    public LocalDate getNedlukningStart() {
        return nedlukningStart;
    }

    public void setNedlukningStart(LocalDate nedlukningStart) {
        this.nedlukningStart = nedlukningStart;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }
}
