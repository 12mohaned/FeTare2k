package com.example.FeTare2k.repos;

import com.example.FeTare2k.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
    Profile findByPhone(int phone);

    Profile findByEmail(String email);
}
