package lld.snakeAndLadder.util;

import lld.snakeAndLadder.entity.Board;
import lld.snakeAndLadder.entity.Game;
import lld.snakeAndLadder.entity.SpecialEntity;

import java.util.Map;

public class PrintUtil {
    public static  void printBoard(Game game){
        for (int i = 0; i < game.getBoard().size(); i++) {
            if (i%10==0){
                System.out.println();
            }
            Board te=game.getBoard().get(i);
            if (te.isSpecialEntity()){
                System.out.print("  "+game.getBoard().get(i).getNum()+""+te.getSpecialEntityType()+" ");
            }else
             System.out.print(" "+ game.getBoard().get(i).getNum());
        }
    }

    public static void printSnake() {
        System.out.println();
        for (Map.Entry<Integer, SpecialEntity> cm:Game.map.entrySet()) {
            if (cm instanceof SpecialEntity){
                System.out.println(" LADDER "+cm.getValue());
            }
            else {
                System.out.println(" SNAKE "+cm.getValue());
            }
        }
    }
}
