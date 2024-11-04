package com.example.hotelservice.service;

import com.example.hotelservice.clients.OpenFeinLocation;
import com.example.hotelservice.dao.HotelRepository;
import com.example.hotelservice.domain.Hotel;
import com.example.hotelservice.dto.requests.HotelRequest;
import com.example.hotelservice.dto.responses.HotelResponse;
import com.example.hotelservice.dto.responses.LocationResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;
    private final OpenFeinLocation openfeinLocation;
    private final CircuitLocationService circuitLocationService;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, OpenFeinLocation openfeinLocation, CircuitLocationService circuitLocationService) {
        this.hotelRepository = hotelRepository;
        this.openfeinLocation = openfeinLocation;
        this.circuitLocationService = circuitLocationService;
    }
    @Override
    public long createHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelRequest.getName());
        hotel.setNumberOfStars(hotelRequest.getNumberOfStars());
        hotel.setNumberOfRooms(hotelRequest.getNumberOfRooms());
        hotel.setLocationId(hotelRequest.getLocationId());
        hotelRepository.save(hotel);
        return hotel.getHotelId();
    }

    @Override
    public HotelResponse getHotel(long hotelId) {
        HotelResponse hotelResponse = new HotelResponse();
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new RuntimeException("Hotel with id " + hotelId + " not found"));
        hotelResponse.setHotelId(hotel.getHotelId());
        hotelResponse.setName(hotel.getName());
        hotelResponse.setNumberOfStars(hotel.getNumberOfStars());
        hotelResponse.setNumberOfRooms(hotel.getNumberOfRooms());
            // hotelResponse.setLocationId(hotel.getLocationId());
        hotelResponse.setLocationResponse(circuitLocationService.getLocationById(hotel.getLocationId()));

        return hotelResponse;


    }
    // public LocationResponse getLocationById(long locationId){
    //     /*RestTemplate restTemplate = new RestTemplate();
    //     String uri = "http://localhost:8081/api/locations/{id}";
    //     LocationResponse locationResponse = restTemplate.getForObject(uri, LocationResponse.class, locationId);*/

    //     //LocationResponse locationResponse = locationFeignClient.getLocationById(locationId);
    //     return openFeinLocation.getLocationById(locationId);
    // }

    @CircuitBreaker(name = "locationService")
    public LocationResponse getLocationById(long locationId){
    LocationResponse locationResponse = openfeinLocation.getLocationById(locationId);
    return locationResponse;}


}
