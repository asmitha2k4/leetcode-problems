import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column of queen in row i
        Arrays.fill(queens, -1);
        backtrack(res, queens, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, int[] queens, int row, int n) {
        if (row == n) {
            res.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                backtrack(res, queens, row + 1, n);
                queens[row] = -1; // backtrack
            }
        }
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int qCol = queens[i];
            if (qCol == col || Math.abs(qCol - col) == Math.abs(i - row)) {
                return false; // same column or same diagonal
            }
        }
        return true;
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
