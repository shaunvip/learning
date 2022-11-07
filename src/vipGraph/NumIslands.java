package vipGraph;
//https://leetcode.com/problems/number-of-islands/

/**

 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1
 Example 2:

 Input: grid = abc
 Output: 3

 */
public class NumIslands {
    public static void main(String[] args) {
     char[][] grid=new char[][]{
             {'1', '1', '0', '0', '0'},
             {'1', '1', '0', '0', '0'},
             {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
        };

        numberOfIsland(grid);
    }
    public static int numberOfIsland(char[][] grid){
        int islands=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        System.out.println(islands);
        return islands;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i<0|| j<0 || i> grid.length-1|| j> grid[0].length-1)
            return;
        if (grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }


}
