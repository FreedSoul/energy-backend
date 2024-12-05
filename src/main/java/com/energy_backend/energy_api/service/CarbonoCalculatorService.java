package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.model.CarbonoCalculator;
import com.energy_backend.energy_api.repository.CarbonoCalculatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarbonoCalculatorService {
    private CarbonoCalculatorRepository carbonoRepository;

    public CarbonoCalculatorService(CarbonoCalculatorRepository carbonoRepository) {
        this.carbonoRepository = carbonoRepository;
    }

    public CarbonoCalculator insertCarbonoCalculator(CarbonoCalculator calculator) {
        try {
            return carbonoRepository.save(calculator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CarbonoCalculator> getCarbonoCalculators() {
        try {
            return carbonoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<CarbonoCalculator> getCarbonoCalculator(Integer calculatorId) {
        try {
            return carbonoRepository.findById(calculatorId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
