import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursive backtracking from number 1
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base Case: If the combination has k elements, add it to the result
        if (current.size() == k) {
            result.add(new ArrayList<>(current)); // Create a copy because current changes
            return;
        }

        // Optimization: i <= n - (k - current.size()) + 1
        // This ensures we don't start a loop if there aren't enough numbers left to reach k
        for (int i = start; i <= n; i++) {
            // 1. Choose the number
            current.add(i);
            
            // 2. Explore further (start from i + 1 to avoid duplicates like [1,1])
            backtrack(i + 1, n, k, current, result);
            
            // 3. Backtrack (remove the last number to try the next one)
            current.remove(current.size() - 1);
        }
    }
}
