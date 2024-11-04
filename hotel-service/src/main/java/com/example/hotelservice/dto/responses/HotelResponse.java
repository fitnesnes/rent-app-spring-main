package com.example.hotelservice.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HotelResponse {

    private long hotelId;
    private String name;
    private int numberOfStars;
    private int numberOfRooms;
    //private long locationId;
    LocationResponse locationResponse;

}
