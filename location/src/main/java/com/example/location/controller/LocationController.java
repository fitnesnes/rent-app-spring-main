package com.example.location.controller;

import com.example.location.dto.requests.LocationRequest;
import com.example.location.dto.responses.LocationResponse;
import com.example.location.service.LocationServive;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/locations")

public class LocationController {

    @Autowired
    private LocationServive locationServive;

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @PostMapping
    public ResponseEntity<Void> addLocation(@Valid @RequestBody LocationRequest location) {
        //logger.info("*****************Location {}", location.toString());
        long id = locationServive.addLocation(location);
        //logger.info("*************Location : after persistence");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri ).build();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@Valid @RequestBody LocationRequest location, @PathVariable("id") long locationId) {
        locationServive.updateLocation(location, locationId);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable long id) {
        locationServive.deleteLocation(id);
    }

    @GetMapping
    public List<LocationResponse> getAllLocations(){
        List<LocationResponse> allLocations = new ArrayList<>();
        allLocations = locationServive.getAllLocations();
        return allLocations;

    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable  long id) {

        LocationResponse location = locationServive.getLocationById(id);
        logger.info("****** appel de location avec id : " + id);
        return ResponseEntity.ok().body(location);
    }

}


