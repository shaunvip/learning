package com.example.ola_uber_lld.service;

import com.example.ola_uber_lld.model.Driver;
import com.example.ola_uber_lld.model.book.Cab;
import com.example.ola_uber_lld.model.book.Location;
import com.example.ola_uber_lld.repository.CabRepository;
import com.example.ola_uber_lld.repository.DriverRepository;
import com.example.ola_uber_lld.repository.LocationRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class InitServices {
    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    LocationRepository locationRepository;

    @PostConstruct
     void save(){
        String[] str="Pavan,Amit,sumit,Rahul,vikas,akshay,Raghav,Shreyash,malik,tiwari,thakur,Sanjay".split(",");
        String[] cars="Hyundai-creta, I10,I20,alto,desire,swift,marazzo,wagnor,safari,ciaz,i20,Maruti-estilo".split(",");
        List<Driver> driverList= new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            Driver driver= new Driver(str[i]);

            driverList.add( driverRepository.save(driver));
        }
        Random r = new Random();
        int low = 2005,high = 2022;
        int dl=0,dh=12;
        List<Location> locations=getAllLocations();
        int ll=0,lh=locations.size()-1;
        for (int i = 0; i <12 ; i++) {
            int model = r.nextInt(high-low) + low;
            Cab cab= new Cab(cars[i],model,driverList.get(r.nextInt(dh-dl)+dl),
                    locations.get(r.nextInt(ll+lh)+ll) );
            cabRepository.save(cab);
        }
    }
    public List<Location> getAllLocations(){
        List<Location> list;
        try {
            File file = new ClassPathResource("city.json").getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            list = Arrays.asList(objectMapper.readValue(file, Location[].class));
            locationRepository.saveAll(list);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
