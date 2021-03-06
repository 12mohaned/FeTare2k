package com.example.FeTare2k.controllers;

import java.util.List;
import com.example.FeTare2k.entities.PastRide;
import com.example.FeTare2k.entities.Ride;
import com.example.FeTare2k.entities.RideReservation;
import com.example.FeTare2k.repos.Rides.PastRideRepository;
import com.example.FeTare2k.repos.Rides.RideRepository;
import com.example.FeTare2k.repos.Rides.RideReservationRepository;
import com.example.FeTare2k.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ride")
public class RideController {
    @Autowired
    private RideRepository rideRepo;
    @Autowired
    private PastRideRepository pastrideRepo;
    @Autowired
    private RideReservationRepository ridereservationRepo;
    @Autowired
    private ProfileRepository profileRepo;

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> availableRides() {
        List<Ride> rides = rideRepo.findAll();
        if (rides == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rides);
    }

    @GetMapping("/pastrides/{id}")
    public ResponseEntity<List<PastRide>> pastRides(@PathVariable String id) {
        List<PastRide> PastRides = pastrideRepo.findByemail(id);
        if (PastRides == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PastRides);
    }

    @GetMapping("/upcomingrides/{id}")
    public ResponseEntity<List<RideReservation>> upcomingRides(@PathVariable String id) {
        List<RideReservation> upcomingRides = ridereservationRepo.findBypassenger(id);
        System.out.println(upcomingRides);
        if (upcomingRides.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(upcomingRides);
    }

    @PostMapping("/Addride")
    public Ride publishRide(@RequestBody Ride newRide) {
        newRide.setDriver(profileRepo.findByEmail(newRide.getEmail()));
        return rideRepo.save(newRide);
    }

}
