package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] chessboard;
    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backTracing(n, 0, chessboard);
        return result;
    }
    
    public void backTracing(int n, int row, char[][] chessboard){
        if (n == row){
            LinkedList<String> list = new LinkedList<>();
            for (char[] obj : chessboard) {
                list.add(String.copyValueOf(obj));
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                backTracing(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard){
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}