package com.example.FeTare2k.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "past_rides")
@NoArgsConstructor
public class PastRide {
    @Id
    int id;
    @Getter
    String email;
    @Getter
    String pickup;
    @Getter
    String destination;
    @Getter
    double price;
    @Getter
    String date;

    public PastRide(String userEmail, String pickup, String destination, double price, String date) {
        this.email = userEmail;
        this.pickup = pickup;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

}
