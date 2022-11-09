package lld.minesweeper.entity;

import java.util.UUID;

public class Player {
    private String name;
    private final UUID id=UUID.randomUUID();

    public Player(String name) {
        this.name = name;
    }
}
