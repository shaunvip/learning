package com.example.ola_uber_lld.repository;

import com.example.ola_uber_lld.model.RUser;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;
@GraphQlRepository
public interface UserRepository extends CrudRepository<RUser, Long> , QuerydslPredicateExecutor<RUser> {
}
