package com.example.ola_uber_lld.model.book;

import com.example.ola_uber_lld.model.Driver;
import com.example.ola_uber_lld.model.RUser;
import com.example.ola_uber_lld.model.enums.BookingStatusEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
public class Booking  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdOn;
    private LocalDateTime requestedOn;
    private BookingStatusEnum status;

    @OneToOne(fetch= FetchType.EAGER)
    private Driver driver;
    @OneToOne(fetch= FetchType.EAGER)
    private Location source;
    @OneToOne(fetch= FetchType.EAGER)
    private RUser requestedBy;
    @OneToOne(fetch= FetchType.EAGER)
    private Location destination;

    private BigDecimal amount;
}
