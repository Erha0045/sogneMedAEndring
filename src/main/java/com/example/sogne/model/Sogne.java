package com.example.sogne.model;

import javax.persistence.*;
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
    private Date nedlukningStart;

    @OneToOne
    @JoinColumn(name = "kommune_id", nullable = false)
    private Kommune kommune;

    public Sogne() {
    }

    public Sogne(int sognekode, String navn, double smittetryk, Date nedlukningStart, Kommune kommune) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
        this.kommune = kommune;
    }

    public Sogne(int id, int sognekode, String navn, double smittetryk, Date nedlukningStart, Kommune kommune) {
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

    public Date getNedlukningStart() {
        return nedlukningStart;
    }

    public void setNedlukningStart(Date nedlukningStart) {
        this.nedlukningStart = nedlukningStart;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }

    @Override
    public String toString() {
        return "Sogne{" +
                "id=" + id +
                ", sognekode=" + sognekode +
                ", navn='" + navn + '\'' +
                ", smittetryk=" + smittetryk +
                ", nedlukningStart=" + nedlukningStart +
                ", kommune=" + kommune +
                '}';
    }
}
