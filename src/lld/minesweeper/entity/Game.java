package lld.minesweeper.entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Game {
    private final UUID id;
    private final Board board;
    private Set<Player> players;

    public Game(int size) {
        this.id = UUID.randomUUID();
      this.board=  this.initiateBoard(size);
    }

    private Board initiateBoard(int size) {
        int bomb=10;
        switch (size){
            case 1:
                size=9;
                break;
            case 2:
                size=16;
                bomb=40;
                break;
            case 3:
                size=24;
                bomb=99;
                break;
            default:
                size=9;
                System.out.println("Invalid value , Play a beginner Game ");
        }
        Board board= new Board(size);

        board.addBomb(bomb,size);
        board.addPoints(bomb*3,size);
        board.print();
        return board;
    }
    public Board getBoard() {
        return board;
    }

    public Set<Player> getPlayers() {
        players= Optional.ofNullable(players).orElse(new HashSet<>());
        return players;
    }

    public int move(int val) {

        return 0;
    }
}
