package lld.rentalCar.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public  abstract class BaseEntity {
    private UUID id=UUID.randomUUID();
    private LocalDateTime initiatedOn=LocalDateTime.now();

    public LocalDateTime getInitiatedOn() {
        return initiatedOn;
    }

    public void setInitiatedOn(LocalDateTime initiatedOn) {
        this.initiatedOn = initiatedOn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
