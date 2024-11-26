package com.energy_backend.energy_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity //Ayuda a que la clase se comporte como entidad
@Table(name = "users") //Anotación para nombrar la tabla
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que la primarykey sea autoincremental
    private Integer id;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "phone", nullable = false, length = 255)
    private String phone;

    //Relación de uno a muchos
    @OneToMany(mappedBy = "user") // Inverse side
    private List<Comment> comments;

    //Constructor
    public User(String phone, String password, String email, String username) {
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public User() {}

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
