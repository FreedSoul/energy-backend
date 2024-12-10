package com.energy_backend.energy_api.service;

//import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.User;
import com.energy_backend.energy_api.repository.UserRepository;
import com.energy_backend.energy_api.repository.classes.login;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//Para trabajar con las interfaz repository
@Service //Para que la clase se comporte como un servicio
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Optional se usa para evitar NullPointerException si el usuario no se encuentra
    public Optional<User> getUserById(Integer id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el usuario con ID:" + id , e);
        }
    }

    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario ", e);
        }
    }

    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario ", e);
        }
    }

    public Optional<User> partialUpdateUser(Integer id, Map<String, Object> updates) {
        try {
            return userRepository.findById(id).map(user -> {
                updates.forEach((key, value) -> {
                    Field field = ReflectionUtils.findField(User.class, key);
                    if(field != null) {
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, user, value);
                    }
                });
                return userRepository.save(user);
            });
        } catch (Exception e) {
            throw new RuntimeException("Error a la actualización parcial del usuario con ID:" + id , e);
        }
    }

    public void deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario con ID:" + id, e);
        }
    }

    public User Login(login userDetails) {
        return userRepository.findUserByNameAndPassword(userDetails.username, userDetails.password).getFirst();
    }
}
