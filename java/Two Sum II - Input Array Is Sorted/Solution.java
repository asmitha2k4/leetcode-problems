class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            // Found the matching pair
            if (currentSum == target) {
                // The problem requires 1-indexed results
                return new int[]{left + 1, right + 1};
            } 
            // If the sum is smaller than target, move left pointer forward
            else if (currentSum < target) {
                left++;
            } 
            // If the sum is larger than target, move right pointer backward
            else {
                right--;
            }
        }
        
        // Return an empty array if no solution is found (guaranteed not to hit based on constraints)
        return new int[]{-1, -1};
    }
}
