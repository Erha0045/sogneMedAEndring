package com.example.sogne.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "kommune")
public class Kommune {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;

    @JsonManagedReference
    @OneToMany(mappedBy = "kommune",cascade = CascadeType.ALL)
    private Set<Sogne> sogne;

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

    public Set<Sogne> getSogne() {
        return sogne;
    }

    public void setSogne(Set<Sogne> sogne) {
        this.sogne = sogne;
    }

    @Override
    public String toString() {
        return  "id: " + id +"  :  " + navn;
    }
}
