package lld.minesweeper.entity;

import java.util.UUID;

public class Cell {
    private Type type;
    private UUID specialEntityId;

    public Cell() {
        this.type = Type.D;
    }

    public Type getType() {
        return type;
    }

    public UUID getSpecialEntityId() {
        return specialEntityId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSpecialEntityId(UUID specialEntityId) {
        this.specialEntityId = specialEntityId;
    }

    @Override
    public String toString() {
        return type.name() ;
    }
}
enum Type{
    B,P,D;
}
