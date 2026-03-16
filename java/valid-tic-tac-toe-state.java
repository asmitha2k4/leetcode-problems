class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        // 1. Count X and O
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }

        // Rule 1: Basic count check
        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }

        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');

        // Rule 4: Both cannot win
        if (xWins && oWins) return false;

        // Rule 2: If X wins, X count must be O count + 1
        if (xWins && xCount != oCount + 1) return false;

        // Rule 3: If O wins, X count must be exactly O count
        if (oWins && xCount != oCount) return false;

        return true;
    }

    // Helper to check if a specific player has 3 in a row
    private boolean checkWin(String[] board, char p) {
        // Check Rows and Columns
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) return true;
        }
        // Check Diagonals
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) return true;
        
        return false;
    }
}
