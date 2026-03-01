class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        int[] queens = new int[n]; // queens[i] = column of queen in row i
        java.util.Arrays.fill(queens, -1);
        backtrack(queens, 0, n);
        return count;
    }

    private void backtrack(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, row + 1, n);
                queens[row] = -1; // backtrack
            }
        }
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int qCol = queens[i];
            if (qCol == col || Math.abs(qCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
