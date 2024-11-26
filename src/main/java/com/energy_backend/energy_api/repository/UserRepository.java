package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa dependencia de java que nos ayuda a persistir (operaciones en BD)
@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
}
