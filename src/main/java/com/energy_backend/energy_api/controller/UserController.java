package com.energy_backend.energy_api.controller;

//import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.User;
import com.energy_backend.energy_api.repository.classes.login;
import com.energy_backend.energy_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController //Encargado de manejar los endpoints
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al consultar los usuarios " + e);
        }
    }

    // @PathVariable extrae el ID del usuario desde la URL
    // ResponseEntity permite controlar el código de respuesta HTTP y el cuerpo de la respuesta
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        try {
            return userService.getUserById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al consultar el usuario por id" + e);
        }
    }

    @PostMapping("/user")
    public User createtUser(@RequestBody User user) {
        try {
            return userService.createUser(user);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar el usuario " + e);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                user.get().setUsername(userDetails.getUsername());
                user.get().setEmail(userDetails.getEmail());
                user.get().setPassword(userDetails.getPassword());
                user.get().setPhone(userDetails.getPhone());
                return ResponseEntity.ok(userService.createUser(user.get()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return userService.partialUpdateUser(id, updates)
                .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/login")
    public User Login(@RequestBody login loginDetails) {
        try {
            return userService.Login(loginDetails);
        } catch (RuntimeException e) {
            throw new RuntimeException("Usuario no encontrado " + e);
        }
    }
}

