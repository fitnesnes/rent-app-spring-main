package com.example.hotelservice.service;

import com.example.hotelservice.dto.requests.HotelRequest;
import com.example.hotelservice.dto.responses.HotelResponse;

public interface HotelService {
    public long createHotel(HotelRequest hotelRequest);
    public HotelResponse getHotel(long hotelId);

}
