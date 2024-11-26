package com.energy_backend.energy_api.controller;

//import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.User;
import com.energy_backend.energy_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //Encargado de manejar los endpoints
//@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al consultar los usuarios " + e);
        }
    }

//    @GetMapping("/user/{userId}")
//    public User getUserById() {
//        try {
//            return userService.getUserById(userId);
//        } catch (RuntimeException e) {
//            throw new RuntimeException("Error al consultar el usuario " + e);
//        }
//    }

    @PostMapping("/user")
    public User createtUser(@RequestBody User user) {
        try {
            return userService.createUser(user);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar el usuario " + e);
        }
    }
}
