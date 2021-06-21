package com.example.sogne.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kommune")
public class Kommune {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;

    public Kommune() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Kommune{" +"id=" + id +
                ", navn='" + navn + '\'' +
                '}';
    }
}
