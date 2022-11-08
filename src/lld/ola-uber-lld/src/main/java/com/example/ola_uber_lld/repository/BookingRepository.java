package com.example.ola_uber_lld.repository;

import com.example.ola_uber_lld.model.book.Booking;
import com.example.ola_uber_lld.model.book.Cab;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookingRepository extends CrudRepository<Booking, Long> , QuerydslPredicateExecutor<Booking> {
}
