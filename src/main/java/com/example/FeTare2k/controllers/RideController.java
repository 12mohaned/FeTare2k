package com.example.FeTare2k.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.FeTare2k.entities.PastRide;
import com.example.FeTare2k.entities.Ride;
import com.example.FeTare2k.repos.Rides.PastRideRepository;
import com.example.FeTare2k.repos.Rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ride")
public class RideController {
    @Autowired
    private RideRepository rideRepo;
    @Autowired
    private PastRideRepository pastrideRepo;

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
    public ResponseEntity<List<Ride>> upcomingRides(@PathVariable String id) {
        List<Ride> availableRides = rideRepo.findAll();
        List<Ride> upcomingRides = new ArrayList<Ride>();
        for (int ride = 0; ride < availableRides.size(); ride++) {
            if (availableRides.get(ride).getUsers().contains(id)) {
                upcomingRides.add(availableRides.get(ride));
            }
        }
        System.out.println(upcomingRides);
        if (availableRides.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(upcomingRides);
    }
}
