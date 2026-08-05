public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XOR all elements in the array
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {2, 2, 1};
        System.out.println("Output 1: " + sol.singleNumber(nums1)); // Expected: 1

        // Example 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Output 2: " + sol.singleNumber(nums2)); // Expected: 4

        // Example 3
        int[] nums3 = {1};
        System.out.println("Output 3: " + sol.singleNumber(nums3)); // Expected: 1
    }
}
