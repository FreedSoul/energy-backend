package com.energy_backend.energy_api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "carbono_calculator")
public class CarbonoCalculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "user_id")
    private User user;
    @Column(name = "result", nullable = false)
    private int result;
    @Column(name = "date_result", nullable = false)
    private Date date_result;

    //Contructor
    public CarbonoCalculator(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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