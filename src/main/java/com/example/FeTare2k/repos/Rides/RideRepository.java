package com.example.FeTare2k.repos.Rides;

import com.example.FeTare2k.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {
    Ride findByid(int id);
}
