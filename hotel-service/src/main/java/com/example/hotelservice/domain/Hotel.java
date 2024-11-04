package com.example.hotelservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;
    private String name;
    @Column(name = "stars")
    private int numberOfStars;
    @Column(name = "rooms")
    private int numberOfRooms;
    @Column(name = "location_id")
    private long locationId;

}
