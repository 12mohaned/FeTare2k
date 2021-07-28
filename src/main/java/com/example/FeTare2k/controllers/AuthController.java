package com.example.FeTare2k.controllers;

import com.example.FeTare2k.entities.Profile;
import com.example.FeTare2k.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private ProfileRepository ProfileRepo;
    private static final String FORGET_PATH = "/forget";
    private static final String RESET_PATH = "/reset";
    private static final String confirm_path = "confirm_token";

    @GetMapping(value = RESET_PATH)
    public String ResetPasswordSubmit() {
        return "reset_password";
    }

    @PostMapping(value = RESET_PATH)
    public String ResetPasswordSubmit(String password) {
        boolean token = password != null ? true : false;
        if (token) {
            Profile profile = ProfileRepo.findByEmail("mohaned.mashaly12@gmail.com");
            profile.setPassword("tarekandamr");
            ProfileRepo.save(profile);
        }
        return "reset_password";
    }

    @GetMapping(value = FORGET_PATH)
    public String ForgetPasswordSubmit() {
        return "forget_password";
    }

    @PostMapping(value = FORGET_PATH)
    public String ForgetPasswordSubmit(String token) {
        Profile phoneExists = null;
        try {
            phoneExists = ProfileRepo.findByPhone(Integer.parseInt(token));

        } catch (Exception e) {
        }
        boolean user_verified = !ProfileRepo.findById(token).isEmpty() | phoneExists != null ? true : false;
        if (user_verified) {
            return ResetPasswordSubmit();
        }
        return confirm_path;
    }

}
