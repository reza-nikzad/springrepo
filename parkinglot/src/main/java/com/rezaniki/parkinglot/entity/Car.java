package com.rezaniki.parkinglot.entity;


import javax.persistence.*;

@Entity
@Table(name = "parkingcars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;

    private String numberplate;
    private long entertime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public long getEntertime() {
        return entertime;
    }

    public void setEntertime(long entertime) {
        this.entertime = entertime;
    }
}

