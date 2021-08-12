package com.example.FeTare2k.repos;

import com.example.FeTare2k.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
