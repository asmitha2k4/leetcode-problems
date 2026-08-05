class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        for (int i = 0; i < n; i++) {
            int complement = target - numbers[i];
            
            // Binary search for the complement in the right subarray
            int left = i + 1;
            int right = n - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (numbers[mid] == complement) {
                    return new int[]{i + 1, mid + 1}; // 1-indexed conversion
                } else if (numbers[mid] < complement) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}
