package com.example.ola_uber_lld.service;

import com.example.ola_uber_lld.repository.BookingRepository;
import com.example.ola_uber_lld.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServices {
    @Autowired
    BookingRepository bookingRepository;
}
