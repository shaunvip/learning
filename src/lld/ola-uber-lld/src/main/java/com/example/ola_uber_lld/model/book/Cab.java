package com.example.ola_uber_lld.model.book;

import com.example.ola_uber_lld.model.RUser;
import com.example.ola_uber_lld.model.enums.CabStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Cab  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdOn;
    private String name;
    private Integer model;
    private CabStatus cabStatus;
    @OneToOne
    private RUser owner;
    @OneToOne(cascade = CascadeType.MERGE)
    private Location location;

    public Cab(String name, Integer model, RUser owner, Location location) {
        this.name = name;
        this.model = model;
        this.cabStatus = CabStatus.AVAILABLE;
        this.owner = owner;
        this.location = location;
        this.createdOn=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Cab{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", cabStatus=" + cabStatus +
                ", owner=" + owner +
                ", location=" + location +
                ", id=" + id +
                ", createdOn=" + createdOn +
                '}';
    }
}
