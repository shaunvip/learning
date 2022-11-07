package DP;

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {0, 1, 2, 3, 4, 5},
                { 6, 7, 8, 9, 10, 11},
                {12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23}};
        int rowStart=0;// 0
        int rowEnds=matrix[0].length-1; // 05
        int colLast= matrix.length-1;
        int colStart=0;


        while(rowStart<rowEnds && colStart<colLast){
            for(int i=rowStart;i<=rowEnds;i++){  // for right Navigation
                System.out.print(matrix[rowStart][i]+" ");
            }
            rowStart++;
            for (int i = rowStart; i <= colLast; i++) {
                System.out.print(matrix[i][rowEnds]+" ");
            }
            rowEnds--;
            for (int i = rowEnds; i >= colStart; i--) {
                System.out.print(matrix[colLast][i]+" ");
            }
            colLast--;
            for (int i =colLast ; i >= rowStart; i--) {
                System.out.print(" "+matrix[i][colStart]);
            }
            colStart++;

        }
    }
}
