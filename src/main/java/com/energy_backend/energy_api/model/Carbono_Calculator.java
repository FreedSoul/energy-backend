package com.energy_backend.energy_api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "carbono_calculator")
public class Carbono_Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id", nullable = false)
    private int user_id;
    @Column(name = "result", nullable = false)
    private int result;
    @Column(name = "date_result", nullable = false)
    private Date date_result;

    //Contructor
    public Carbono_Calculator(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate_result() {
        return date_result;
    }

    public void setDate_result(Date date_result) {
        this.date_result = date_result;
    }
}
