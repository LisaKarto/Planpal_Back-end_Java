package com.TodoListApplication.TodoList.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "lijsten")
public class Lijst {

    private int idlijst;
    private String lijstNaam;
    private String lijstSoort;

    public Lijst() {

    }

    public Lijst(int lijstId, String lijstNaam, String lijstSoort) {
        this.idlijst = lijstId;
        this.lijstNaam = lijstNaam;
        this.lijstSoort = lijstSoort;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getIdlijst() {
        return this.idlijst;
    }
    public void setIdlijst(int idlijst)
    {
        this.idlijst = idlijst;
    }

    public String getLijstNaam(){
        return this.lijstNaam;
    }

    public void setLijstNaam(String lijstnaam){
        this.lijstNaam = lijstnaam;
    }

    public String getLijstSoort(){
        return this.lijstSoort;
    }

    public void setLijstSoort(String lijstsoort){
        this.lijstSoort = lijstsoort;
    }
}
