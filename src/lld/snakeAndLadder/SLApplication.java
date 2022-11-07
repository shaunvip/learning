package lld.snakeAndLadder;

import lld.snakeAndLadder.entity.Board;
import lld.snakeAndLadder.entity.Game;
import lld.snakeAndLadder.entity.Player;
import lld.snakeAndLadder.entity.SpecialEntity;
import lld.snakeAndLadder.util.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import static lld.snakeAndLadder.entity.Game.map;

public class SLApplication {
    public static void main(String[] args) throws InterruptedException {
        intiateMatch();
    }

    private static void intiateMatch() throws InterruptedException {
        Game game = new Game();
        game.initiateBoard();
        game.setSnake();
        game.setLadder();
        PrintUtil.printBoard(game);
        Player player = new Player("P1");
        Player player2 = new Player("P2");
        game.getPlayers().add(player);
        game.getPlayers().add(player2);
        startGame(game);
        // PrintUtil.printSnake();
    }

    private static void startGame(Game game) throws InterruptedException {
        System.out.println();
        Queue<Player> queue = new LinkedList<>(game.getPlayers());
        Random random = new Random();
        Scanner scanner= new Scanner(System.in);
        while (!queue.isEmpty()) {
            Player player = queue.poll();
            Thread.sleep(3000);
            int num = random.ints(1, 7).findFirst().getAsInt();
            int cp = player.getPosition();
            int fp = cp + num;
            System.out.print(" Player " + player + " turn and got "+num+"  cp "+cp+" next pos "+fp);
            if (game.getBoard().get(fp-1).isSpecialEntity()) {
                System.out.println(" Board has some entity ");
                Board cb = game.getBoard().get(fp-1);
                SpecialEntity specialEntity = map.get(fp);
                fp = map.get(fp).getEnd();
                System.out.println(" "+player + " hit by " + cb.getSpecialEntityType() + " " + specialEntity +" now final pos "+fp+" ");

            }
            System.out.printf("  moving player from %d to %d \n",player.getPosition(),fp);
           if (fp>=game.getBoard().size()){
               System.out.println(" HURREY "+player+" won the match ");
               break;
           }
            player.setPosition(fp);
            queue.add(player);
        }
    }
}
