class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // dp[i][j] represents the minimum health needed *before* entering room (i, j)
        int[][] dp = new int[m][n];
        
        // Base Case: Calculate the health needed for the bottom-right room (the princess)
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        // Fill the last column (can only move DOWN from here)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        // Fill the last row (can only move RIGHT from here)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        // Fill the rest of the DP table grid from bottom to top, right to left
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // Find the minimum health needed to move either right or down
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                
                // Calculate the health needed before entering the current room
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }
        
        // The answer is the minimum initial health required at the starting room (0, 0)
        return dp[0][0];
    }
}
