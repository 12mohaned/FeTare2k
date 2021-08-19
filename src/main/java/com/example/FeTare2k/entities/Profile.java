package com.example.FeTare2k.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
    public int phone;

    public Profile(String email, String firstname, String lastname, int phone) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

}