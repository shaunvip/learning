package lld.snakeAndLadder.entity;

import java.util.UUID;

public class Board {
    UUID id;
    int num;
    boolean specialEntity;
    UUID specialEntityId;
    String specialEntityType;

    public Board(int num) {
        this.num = num;
        this.id=UUID.randomUUID();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isSpecialEntity() {
        return specialEntity;
    }

    public void setSpecialEntity(boolean specialEntity) {
        this.specialEntity = specialEntity;
    }

    public UUID getSpecialEntityId() {
        return specialEntityId;
    }

    public void setSpecialEntityId(UUID specialEntityId) {
        this.specialEntityId = specialEntityId;
    }

    public String getSpecialEntityType() {
        return specialEntityType;
    }

    public void setSpecialEntityType(String specialEntityType) {
        this.specialEntityType = specialEntityType;
    }
}
