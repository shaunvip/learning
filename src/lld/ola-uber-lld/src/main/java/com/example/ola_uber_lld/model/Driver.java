package com.example.ola_uber_lld.model;

import com.example.ola_uber_lld.model.enums.UserEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
@NoArgsConstructor
public class Driver extends RUser{

  private boolean available;

  public Driver(String  name) {
    this.userType = UserEnum.DRIVER;
    this.name=name;
    this.available=false;
    this.createdOn= LocalDateTime.now();
  }
}
