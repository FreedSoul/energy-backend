package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Repositorio JPA que maneja las operaciones de base de datos para la entidad User
// JpaRepository proporciona métodos básicos de CRUD (Create, Read, Update, Delete)
@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    List<User> findUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
