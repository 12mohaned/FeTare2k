package com.example.FeTare2k.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    public int id;
    @Getter
    public String pickup;
    @Getter
    public String destination;
    @Getter
    public String date;
    @Getter
    public String time;
    @Getter
    public int passengers;
    @Getter
    public int luggage;
    @Getter
    public double price;
    @Getter
    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "email")
    public Profile driver;

    @Getter
    @Setter
    public ArrayList<String> users;

    static String[] Status = { "Completed", "Cancelled", "Pending", "Upcoming" };

    public Ride(int RideID, String pickup, String destination, String date, String time, int passengers, int luggage,
            double price, Profile driver) {
        this.users = new ArrayList<String>();
        this.id = RideID;
        this.pickup = pickup;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.passengers = passengers;
        this.luggage = luggage;
        this.price = price;
        this.driver = driver;
    }

}