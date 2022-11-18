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
        chessProblem.moveKnight(grid,kR,kC,6,7);

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
}
