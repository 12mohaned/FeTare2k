package com.example.FeTare2k.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
@NoArgsConstructor
public class Profile {
    @Getter
    public String firstname;
    @Getter
    public String lastname;
    @Getter
    @Id
    public String email;
    @Getter
    @Setter
    public String bio;
    @Setter
    private String password;
    @Getter
    public int phone;

    public Profile(String email, String firstname, String lastname, String bio, int phone, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.phone = phone;
        this.password = password;
    }

}