package vipGraph;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid={
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,1,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid3={
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,1,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid4={
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,1,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        numberOfIsland(grid);
        totalNumberOfIsland(grid3);
        int[][] grid2 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println(">>>>>");
        perimeterOfIsland(grid2);
        System.out.println(">>>>> ");
        perimeterOfIsland(grid4);
    }



    private static void perimeterOfIsland(int[][] grid) {
        int islands=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    islands+= dfsPerimeter(grid,i,j);
                }
            }
        }
        System.out.println(islands);
    }

    private static int dfsPerimeter(int[][] grid, int i, int j) {
    if (i<0|| j<0 || i> grid.length-1|| i> grid[0].length-1){
        return 1;
    }
    if (grid[i][j]==0)
        return 1;
    if (grid[i][j]==-1)
        return 0;
    int count=0;
    grid[i][j] = -1;
    count+=dfsPerimeter(grid, i+1, j);
    count+=dfsPerimeter(grid, i-1, j);
    count+=dfsPerimeter(grid, i, j+1);
    count+=dfsPerimeter(grid, i, j-1);
    return count;
    }

    public static int numberOfIsland(int[][] grid){
        int islands=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                   islands=  Math.max(islands,dfs(grid,i,j));
                }
            }
        }
        System.out.println("MaxNumberOfIsland >>"+islands);
        return islands;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i<0|| j<0 || i> grid.length-1|| j> grid[0].length-1)
            return 0;
        if (grid[i][j]==0)
            return 0;
        grid[i][j]=0;
        return 1+dfs(grid,i+1,j)+ dfs(grid,i-1,j)+ dfs(grid,i,j+1)+ dfs(grid,i,j-1);
    }
    private static void totalNumberOfIsland(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    dfs2(grid,i,j);
                    res++;
                }
            }
        }
        System.out.println("totalNumberOfIsland >>"+res);
    }

    private static int dfs2(int[][] grid, int i, int j) {
        if (i> grid.length-1|| i<0 )
            return 0;
        if (j> grid[0].length -1|| j<0) return 0;
        if (grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+dfs2(grid, i+1, j)
                +dfs2(grid, i-1, j)
                +dfs2(grid, i, j+1)
                +dfs2(grid, i, j-1);
    }

}
