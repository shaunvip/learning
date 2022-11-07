package lld.snakeAndLadder.entity;

import java.util.*;

public class Game {
    public static final String SNAKE = "SNAKE";
    public static final String LADDER = "LADDER";
    private final UUID id= UUID.randomUUID();
    private Set<Player> players;
    List<Board> board= new ArrayList<>(99);
    private transient Set<Integer> set= new HashSet<>();
    public static Map<Integer,SpecialEntity> map= new HashMap<>();


    public Game() {
    }

    public Game(Set<Player> players, Board board) {

        this.players = players;
    }

    public Set<Player> getPlayers() {
        players= Optional.ofNullable(players).orElse(new HashSet<>(2));
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public List<Board> getBoard() {
        return board;
    }

    public void initiateBoard() {

        for (int i = 1; i <=99 ; i++) {
        Board temp= new Board(i);
            board.add(temp);
        }
    }
    public void setLadder(){
        Random random= new Random();
        for (int i = 1; i <= 8; i++) {

            Board tb= board.get(random.ints(0, 99).findFirst().getAsInt());
            int start=tb.num;
            int end= random.ints(8, 99).findFirst().getAsInt();
            if (set.contains(start) || set.contains(end) || start>=end || end-start<=9){
                i--;
                continue;
            }
            set.add(start);
            set.add(end);
            System.out.printf("\n start %d end %d  ",start,end);
            SpecialEntity ladderEntity = new LadderEntity(start,end);
            tb.setSpecialEntityType(LADDER);
            tb.setSpecialEntity(true);
            map.put(start,ladderEntity);
            tb.setSpecialEntityId(ladderEntity.getId());
        }
    } public void setSnake(){
        Random random= new Random();
        for (int i = 1; i <=12; i++) {
            Board tb= board.get(random.ints(0, 97).findFirst().getAsInt());
            int mouth= tb.num;
            int tail= random.ints(8, 99).findFirst().getAsInt();
           if (set.contains(tail) || set.contains(mouth) || mouth<=tail){
               i--;
               continue;
           }
            set.add(tail);
            set.add(mouth);
            System.out.printf("\n SNAKE start %d end %d ",mouth,tail);
            SpecialEntity snakeEntity = new SnakeEntity(mouth,tail);
            tb.setSpecialEntityType(SNAKE);
            tb.setSpecialEntity(true);
            map.put(mouth,snakeEntity);
            tb.setSpecialEntityId(snakeEntity.getId());
        }
    }
}
