package lld.minesweeper;

import lld.minesweeper.entity.Game;
import lld.minesweeper.entity.Player;

import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        initiateGame();
    }

    private static void initiateGame() {
        System.out.println("Please enter Level 1- Beginner 2 - Intermediate 3 - Advanced ");
        Scanner scanner= new Scanner(System.in);
        int size=scanner.nextInt();

        Game game= new Game(size);
       Player player= new Player("P1");
        game.getPlayers().add(player);
        int totalPoints=0;
        while(true) {
            System.out.println("Please enter cell number to move");
            int val=scanner.nextInt();
            // validate bound
           int re= game.move(val);
           if (re>=1){
               totalPoints+=re;
           } else if (re==-1) {
               System.out.println("YOU LANDED ON BOMB");
               break;
           }else {
               System.out.println("ALL Mines explored won the game");
               break;
           }
        }
        System.out.println(totalPoints);
     }
}
