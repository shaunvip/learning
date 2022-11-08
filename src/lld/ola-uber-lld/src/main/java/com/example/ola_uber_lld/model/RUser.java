package com.example.ola_uber_lld.model;

import com.example.ola_uber_lld.model.enums.UserEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
public class RUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected LocalDateTime createdOn;
    protected String name;
    protected UserEnum userType;
}
