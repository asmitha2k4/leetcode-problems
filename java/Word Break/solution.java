import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert the list to a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        int n = s.length();
        // dp[i] will be true if s[0...i-1] can be segmented into dictionary words
        boolean[] dp = new boolean[n + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true;
        
        // Iterate through all possible ending positions of substrings
        for (int i = 1; i <= n; i++) {
            // Check all possible starting positions for the current suffix
            for (int j = 0; j < i; j++) {
                // If the prefix s[0...j-1] is valid and the suffix s[j...i-1] is in the dict
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check other partitions for index i
                }
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("Output 1: " + sol.wordBreak(s1, wordDict1)); // Expected: true

        // Example 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("Output 2: " + sol.wordBreak(s2, wordDict2)); // Expected: true

        // Example 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Output 3: " + sol.wordBreak(s3, wordDict3)); // Expected: false
    }
}
