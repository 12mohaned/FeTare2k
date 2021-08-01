package com.example.FeTare2k.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ride_reservation")
@NoArgsConstructor
public class RideReservation {
    @Id
    @Getter
    int reservation_id;
    @Getter
    @Setter
    String passenger;
    @Getter
    @Setter
    String status;
    @Getter
    @Setter
    int ride;

    public RideReservation(int reservation_id, String passenger, String status, int ride) {
        this.reservation_id = reservation_id;
        this.passenger = passenger;
        this.status = status;
        this.ride = ride;
    }

}
