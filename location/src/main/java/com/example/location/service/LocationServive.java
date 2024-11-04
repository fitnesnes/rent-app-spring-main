package com.example.location.service;

import com.example.location.dto.requests.LocationRequest;
import com.example.location.dto.responses.LocationResponse;

import java.util.List;

public interface LocationServive {
    public long addLocation(LocationRequest location);
    public LocationResponse getLocationById(long id);
    public List<LocationResponse> getAllLocations();
    public void updateLocation(LocationRequest location, long locationId);
    public void deleteLocation(long locationId);
}


