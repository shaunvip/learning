package lld.minesweeper.entity;

import java.util.UUID;

public  class Points {
    int value;
    private final UUID id;

    public Points(int value) {
        this.value = value;
        this.id=UUID.randomUUID();
    }

    public int getValue() {
        return value;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return  ""+value;
    }
}
