import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    // Memoization map to store calculated results for suffixes of s
    private Map<String, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // If the result for this substring is already computed, return it
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> results = new ArrayList<>();

        // Base case: if the string is empty, return a list containing an empty string
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        // Try every possible prefix of the current string
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            // If the prefix exists in the dictionary, find solutions for the remaining suffix
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixSubResults = backtrack(suffix, wordSet);

                // Combine the valid prefix with all valid suffix combinations
                for (String subResult : suffixSubResults) {
                    if (subResult.isEmpty()) {
                        results.add(prefix);
                    } else {
                        results.add(prefix + " " + subResult);
                    }
                }
            }
        }

        // Store the computed results in the memoization table before returning
        memo.put(s, results);
        return results;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println("Output 1: " + sol.wordBreak(s1, wordDict1));
        // Expected: [cat sand dog, cats and dog]

        // Example 2
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println("Output 2: " + sol.wordBreak(s2, wordDict2));
        // Expected: [pine apple pen apple, pine applepen apple, pineapple pen apple]

        // Example 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Output 3: " + sol.wordBreak(s3, wordDict3));
        // Expected: []
    }
}
