package com.example.FeTare2k.controllers;

import com.example.FeTare2k.repos.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FeTare2k.entities.Profile;

@RestController
@RequestMapping("/user")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepo;

    @GetMapping("/{id}")
    public ResponseEntity<Profile> profileInformation(@PathVariable String id) {
        Profile user = profileRepo.findByEmail(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/Adduser")
    public Profile addUser(@RequestBody Profile profile) {
        return profileRepo.save(profile);
    }

    @PutMapping("/User/{id}")
    public Profile saveResource(@RequestBody Profile profile, @PathVariable("id") String id) {
        return profileRepo.save(profile);
    }

}
