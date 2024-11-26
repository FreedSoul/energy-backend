package com.energy_backend.energy_api.controller;

import com.energy_backend.energy_api.model.CarbonoCalculator;
import com.energy_backend.energy_api.service.CarbonoCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarbonoCalculatorController {
    private final CarbonoCalculatorService carbonoCalculatorService;

    @Autowired
    public CarbonoCalculatorController(CarbonoCalculatorService carbonoCalculatorService) {
        this.carbonoCalculatorService = carbonoCalculatorService;
    }

    @PostMapping("/carbono-calculator")
    public ResponseEntity<String> findById(@RequestBody CarbonoCalculator calculatorBody) {
        carbonoCalculatorService.insertCarbonoCalculator(calculatorBody);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registro insertado con exito!");
    }

    @GetMapping("/carbono-calculator")
    public List<CarbonoCalculator> getAllRegisters(){
        return carbonoCalculatorService.getCarbonoCalculators();

    }

    @GetMapping("/carbono-calculator/{calculatorId}")
    public CarbonoCalculator getById(@PathVariable Integer calculatorId){
        return carbonoCalculatorService.getCarbonoCalculators().get(calculatorId);

    }
}
