package com.example.FeTare2k.repos.Rides;

import java.util.List;

import com.example.FeTare2k.entities.RideReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideReservationRepository extends JpaRepository<RideReservation, String> {
    List<RideReservation> findBypassenger(String passenger);
}
