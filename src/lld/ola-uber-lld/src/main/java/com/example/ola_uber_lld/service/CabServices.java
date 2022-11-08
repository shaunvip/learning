package com.example.ola_uber_lld.service;

import com.example.ola_uber_lld.exception.DataNotFoundException;
import com.example.ola_uber_lld.model.book.Cab;
import com.example.ola_uber_lld.model.book.Location;
import com.example.ola_uber_lld.repository.CabRepository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.BooleanOperation;
import com.querydsl.core.types.dsl.Expressions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CabServices {
    @Autowired
    CabRepository cabRepository;

    public boolean updateCabLocation(Integer cabId, Location location) {
        Path<Cab> cabPath= Expressions.path(Cab.class,"cab");
        Path<Long> cabIdPath=Expressions.path(Long.class,cabPath,"id");
        BooleanOperation operation= Expressions.predicate(Ops.MATCHES, cabIdPath, Expressions.constant(cabId));
      Cab cab= cabRepository.findOne(operation).orElseThrow(()->new DataNotFoundException("Cab not Found"));
      cab.setLocation(location);
      cabRepository.save(cab);
        log.info("cab Location updated saved {}",cab);

        return true;
    }
}
