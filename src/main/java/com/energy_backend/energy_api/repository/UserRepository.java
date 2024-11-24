package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Jpa dependencia de java que nos ayuda a persistir (operaciones en BD)
public interface UserRepository extends JpaRepository <User, Integer>{

}
