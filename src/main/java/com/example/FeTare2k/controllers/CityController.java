package com.example.FeTare2k.controllers;

import java.util.List;
import com.example.FeTare2k.entities.City;
import com.example.FeTare2k.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepository cityRepo;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> availableRides() {
        List<City> cities = cityRepo.findAll();
        if (cities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cities);
    }

}
