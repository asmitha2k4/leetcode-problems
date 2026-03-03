class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string and empty pattern match
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, or .* matching an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    // Current characters match, inherit result from diagonal
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Case 1: Match zero times (skip the '*' and the character before it)
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match one or more times (if character before '*' matches s[i-1])
                    char prevP = p.charAt(j - 2);
                    if (prevP == sc || prevP == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
