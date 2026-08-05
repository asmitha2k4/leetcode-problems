import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) {
            return n;
        }

        // Step 1: Initialize candies array with 1 for each child
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Step 2: Left-to-Right pass
        // Ensure a child gets more candies than their left neighbor if their rating is higher
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right-to-Left pass
        // Ensure a child gets more candies than their right neighbor if their rating is higher
        int totalCandies = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] ratings1 = {1, 0, 2};
        System.out.println("Output 1: " + sol.candy(ratings1)); // Expected: 5

        // Example 2
        int[] ratings2 = {1, 2, 2};
        System.out.println("Output 2: " + sol.candy(ratings2)); // Expected: 4
    }
}
