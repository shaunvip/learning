package lld.snakeAndLadder.entity;

import java.util.UUID;

public class Player {
    private UUID uuid;
    private int position;
    String name;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Player(String name) {
        this.name = name;
        this.uuid=UUID.randomUUID();
        this.position=0;
    }

    @Override
    public String toString() {
        return  name;
    }
}
