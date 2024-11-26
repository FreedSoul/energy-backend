package com.energy_backend.energy_api.repository;

import com.energy_backend.energy_api.model.CarbonoCalculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonoCalculatorRepository extends JpaRepository<CarbonoCalculator, Integer> {
}
