package com.example.FeTare2k.repos.Rides;

import java.util.List;

import com.example.FeTare2k.entities.PastRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastRideRepository extends JpaRepository<PastRide, Integer> {
    List<PastRide> findByemail(String email);

}
