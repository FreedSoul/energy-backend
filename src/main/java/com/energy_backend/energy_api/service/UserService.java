package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.User;
import com.energy_backend.energy_api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

//Para trabajar con las interfaces repository
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new DatabaseOperationException("Usuario no encontrado" , e);
        }
    }

    public User createUser(User user)
    {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error al guardar el usuario ", e);
        }
    }
}
