package com.example.ola_uber_lld.model.book;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
public class Location  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdOn= LocalDateTime.now();
    private String name;
    private String country;
    private String lat;
    private String lng;
}

