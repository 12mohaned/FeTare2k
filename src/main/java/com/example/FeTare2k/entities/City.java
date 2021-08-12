package com.example.FeTare2k.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@NoArgsConstructor
public class City {
    @Id
    @Getter
    String name;
    @Getter
    double lat;
    @Getter
    double lon;

    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

}
