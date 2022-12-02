package DP.bt;

import java.util.LinkedList;
import java.util.Queue;

public class ChessProblem {
    public static void main(String[] args) {
        ChessProblem chessProblem= new ChessProblem();
        int K=0;

        int[][] grid={
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,K,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}};
        int kR=4;
        int kC=5;
        System.out.println(chessProblem.moveKnight(grid,kR,kC,6,7));
        kR=kC=1;
        System.out.println(" from 7 1 ======= 1 7");
        System.out.println(chessProblem.minSteps(7,1,1,7));

        System.out.println(chessProblem.minSteps(kR,kC,6,7));

    }
   class  Pair{
        int r,c,dis;

       public Pair(int r, int c,int dis) {
           this.r = r;
           this.c = c;
           this.dis=dis;
       }
   }
    private  int moveKnight(int[][] grid, int kR, int kC,int dR,int dC) {

        // A knight can move in all directions
        int[] moveR ={-2,-2,-1,1, 2,2, 1,-1};
        int[] moveC ={-1,1,  2,2,-1,1,-2,-2};

        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(kR,kC,0));
        while (!queue.isEmpty()){
            Pair temp= queue.poll();
            grid[temp.r][temp.c]=1;
                for (int i = 0; i < moveR.length; i++) {
                    int fR = temp.r + moveR[i];
                    int fC = temp.c + moveC[i];
                    if (fR <= 0 || fC <= 0 || fR >= grid.length || fC >= grid[0].length || grid[fR][fC] != 0) {
                        continue;
                    }
                    if (fR==dR && fC==dC ){
                        return temp.dis;
                    }
                    grid[fR][fC]=1;
                    queue.add(new Pair(fR, fC, temp.dis+1));

            }
        }


        return 0;
    }
    //Minimum number of moves required to reach the destination by the king in a chess board
     int minSteps(int sR, int sC, int dR, int dC) {
        if (sR==dR && sC==dC){
            return 1;
        }
        if(dR>sR && dC>sC){ // both values are bigger we need to move down
            System.out.println (" DR+1 DR ");
            minSteps(sR+1,sC+1,dR,dC);
        }
        else if(dR<sR && dC<sC){ // both values are smaller we need to move up
            System.out.println (" UL -1 ");
            minSteps(sR-1,sC-1,dR,dC);
        }
         if(dR<sR && dC<sC){ // both values are bigger we need to move down
             System.out.println (" DL ");
             minSteps(sR+1,sC-1,dR,dC);
         }
         else if(dR<sR && dC>sC){ // both values are smaller we need to move up
             System.out.println (" UR -1 ");
             minSteps(sR-1,sC+1,dR,dC);
         }
        else if (dR>sR && dC==sC) {
            System.out.println (" D ");
            minSteps(sR+1,sC,dR,dC);
        } else if (dR==sR && dC>sC) {
            System.out.println (" C+1 R ");
            minSteps(sR,sC+1,dR,dC);
        }
         else if (dR<sR && dC==sC) {
            System.out.println (" R - 1 ");
            minSteps(sR-1,sC,dR,dC);
         } else if (dR==sR && dC<sC) {
            System.out.println (" C -1 ");
            minSteps(sR,sC-1,dR,dC);
         }
             else {
            System.out.println("Figure out");
        }
         return 0;
    }

}
