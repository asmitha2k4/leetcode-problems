public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            // 'ones' holds bits that have appeared 1 time (mod 3)
            ones = (ones ^ num) & ~twos;
            
            // 'twos' holds bits that have appeared 2 times (mod 3)
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Output 1: " + sol.singleNumber(nums1)); // Expected: 3

        // Example 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Output 2: " + sol.singleNumber(nums2)); // Expected: 99
    }
}
