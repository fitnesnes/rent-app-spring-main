package com.example.hotelservice.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class HotelRequest {
    private String name;
    private int numberOfStars;
    private int numberOfRooms;
    private long locationId;
}
