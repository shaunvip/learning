package arr;


import java.util.Arrays;

public class MatrixRotate {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
      matrix=rotate(matrix);
        for (int[] cr:matrix) {
            System.out.print(Arrays.toString(cr));
        }
    }
    // 7 4 1(0,2)
    // 8 5 2
    //  9(2,0) 6 3(2,2)
    private static int[][] rotate(int[][] matrix) {
        int[][] res=new int[matrix.length][matrix.length];
        int n= matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i][j]=matrix[n-j][i];
            }
        }

        return res;
    }
}
