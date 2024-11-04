package com.example.location.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class LocationResponse {
    private long locationId;
    private double longitude;
    private double latitude;
}
