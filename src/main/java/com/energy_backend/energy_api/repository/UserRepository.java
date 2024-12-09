package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repositorio JPA que maneja las operaciones de base de datos para la entidad User
// JpaRepository proporciona métodos básicos de CRUD (Create, Read, Update, Delete)
@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
}
