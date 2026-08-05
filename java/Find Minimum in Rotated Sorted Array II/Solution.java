class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Case 1: Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Case 2: Minimum is in the left half or is at mid
            else if (nums[mid] < nums[right]) {
                right = mid;
            } 
            // Case 3: Duplicates encountered! Safely reduce search space by 1
            else {
                right--;
            }
        }
        
        return nums[left];
    }
}
