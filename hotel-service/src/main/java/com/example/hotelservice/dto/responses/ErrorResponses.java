package com.example.hotelservice.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ErrorResponses {
    private String message;
    private String path;
    private Date timestamp;
}
