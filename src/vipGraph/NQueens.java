package vipGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens= new NQueens();
        ArrayList<ArrayList<String>> re= nQueens.solveNQueens(1);
        re.forEach(re1-> re1.forEach(System.out::println));

        re= nQueens.solveNQueens(2);
        re.forEach(re1-> re1.forEach(System.out::println));

        re= nQueens.solveNQueens(4);
        re.forEach(System.out::println);
    }

    ArrayList<ArrayList<String>> solveNQueens(int numberOfQueens) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        String[] nQueens = new String[numberOfQueens];
        char[] init = new char[numberOfQueens];
        Arrays.fill(init, '.');
        Arrays.fill(nQueens, String.valueOf(Arrays.copyOf(init, numberOfQueens)));
        search(numberOfQueens, 0, nQueens, result);
        return result;
    }
    private void search(int numberOfQueens, int row, String[] nQueens, ArrayList<ArrayList<String>> result) {
        if (row == numberOfQueens) {
            result.add(new ArrayList<>(Arrays.asList(nQueens)));
            return;
        }

        for (int col = 0; col < numberOfQueens; col++) {
            if (isValid(nQueens, row, col, numberOfQueens)) {
                char[] chars;
                chars = nQueens[row].toCharArray();
                chars[col] = 'Q';
                nQueens[row] = String.valueOf(chars);
                // nQueens[row][col] = 'Q';
                search(numberOfQueens, row + 1, nQueens, result);
                chars = nQueens[row].toCharArray();
                chars[col] = '.';
                nQueens[row] = String.valueOf(chars);
                // nQueens[row][col] = '.';
            }
        }
    }

    private boolean isValid(String[] nQueens, int row, int col, int n) {
        char[] chars;
        for (int i = 0; i < row; i++) {
            chars = nQueens[i].toCharArray();
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            System.out.println(i);
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }
        for (int  i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
