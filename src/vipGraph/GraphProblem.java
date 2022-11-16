package vipGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphProblem {
    public static void main(String[] args) {
        FloodFill floodFill= new FloodFill();
        floodFill.floodFill(new int[][]{{0,0,0},{0,0,0}},1,0,2);
        System.out.println();
        floodFill.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
        int[][] grid=new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        floodFill.perimeter(grid);
        floodFill.map();
    }
}
class FloodFill{

    public FloodFill(){

    }
    public int[][] floodFill(int[][] image,int sr,int sc,int color) {
        int r=image.length,c=image[0].length;
        if (sr>r || sc>c){
            return image;
        }
        int oldColor=image[sr][sc];
        dfs(image,sr,sc,oldColor,color);
        for (int[] ints : image) {
            for (int j = 0; j < c; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc,int oldColor,int color) {

        if (sr<0 || sc<0 || sc== image[0].length || sr==image.length || image[sr][sc]!=oldColor){
            return;
        }
        if (image[sr][sc]==color){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,oldColor,color);
        dfs(image,sr-1,sc,oldColor,color);
        dfs(image,sr,sc+1,oldColor,color);
        dfs(image,sr,sc-1,oldColor,color);
    }

    public void perimeter(int[][] grid) {
      int result=0;
        for(int r=0;r< grid.length;r++){
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[r][i]==1)
                 result+=dfs(grid,r,i);
            }
        }
        System.out.println(result);
    }

    private int dfs(int[][] grid, int sr, int sc) {
        if (sr<0 || sc<0 || sc== grid[0].length || sr==grid.length){
            return 1;
        }
        if (grid[sr][sc]==0){
            return 1;
        }
        if (grid[sr][sc]==-1){
            return 0;
        }
        int count=1;
        grid[sr][sc]=-1;

        count+=dfs(grid,sr+1,sc);
        count+=dfs(grid,sr-1,sc);
        count+=dfs(grid,sr,sc+1);
        count+=dfs(grid,sr,sc-1);
        return count;
        }

    public void map() {
        Map<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,i);
        }
        int size=map.size()/2;
        int count=0;
        for (Map.Entry<Integer,Integer> cm: map.entrySet()) {
            if (!((count++) < size)) {
                System.out.println(cm.getKey() + " " + cm.getValue());
            }
            else{
                System.out.println(cm.getKey() + " _ ");
            }
        }
    }
}
