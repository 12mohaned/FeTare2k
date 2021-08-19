package com.example.FeTare2k.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ride")
@NoArgsConstructor
public class Ride {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Getter
    public String pickup;
    @Getter
    public String destination;
    @Getter
    public LocalDateTime date;
    @Getter
    public int passengers;
    @Getter
    public int luggage;
    @Getter
    public double price;
    @Getter
    public String email;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "email")
    public Profile driver;

    public Ride(int RideID, String pickup, String destination, LocalDateTime date, int passengers, int luggage,
            double price, String email, Profile driver) {
        this.id = RideID;
        this.pickup = pickup;
        this.destination = destination;
        this.date = date;
        this.passengers = passengers;
        this.luggage = luggage;
        this.price = price;
        this.email = email;
        this.driver = driver;
    }

}