package com.example.ola_uber_lld.service;

import com.example.ola_uber_lld.exception.DataNotFoundException;
import com.example.ola_uber_lld.model.Driver;
import com.example.ola_uber_lld.repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DriverServices {
    DriverRepository driverRepository;
    public DriverServices(DriverRepository dr){
        this.driverRepository=dr;
    }

    public Driver updateDriverStatus(Long id, String online) {
        Driver driver= driverRepository.findById(id).orElseThrow(()->new DataNotFoundException("Invalid Driver ID"));

            driver.setAvailable("YES".equalsIgnoreCase(online));
             driverRepository.save(driver);
             log.info("Driver saved {}",driver);

             return driver;
        }

}
