package com.example.hotelservice.controller;

import com.example.hotelservice.dto.requests.HotelRequest;
import com.example.hotelservice.dto.responses.HotelResponse;
import com.example.hotelservice.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService;


    @PostMapping
    public ResponseEntity<Void> createHotel(@RequestBody HotelRequest hotelRequest) {
        long id = hotelService.createHotel(hotelRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotel(@PathVariable("id") long hotelId){
        HotelResponse hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok().body(hotel);

    }


}
