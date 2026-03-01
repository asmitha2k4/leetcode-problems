class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // max sum found so far
        int currentSum = nums[0]; // max sum ending at current position

        for (int i = 1; i < nums.length; i++) {
            // either extend current subarray or start a new subarray at i
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
