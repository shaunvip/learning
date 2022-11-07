package lld.snakeAndLadder.entity;

import java.util.UUID;

public abstract class SpecialEntity {
     protected  int start;
   protected int end;
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public SpecialEntity(int start, int end) {
        this.start = start;
        this.end = end;
        this.id=UUID.randomUUID();
    }

    @Override
    public String toString() {
        return
                "start=" + start +
                ", end=" + end ;
    }

    public SpecialEntity() {
    }
}
