class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid is less than its right neighbor, we are in an "upward slope"
            // This means a peak element must exist somewhere on the right half.
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // Otherwise, we are in a "downward slope"
            // The mid element itself could be a peak, or the peak is on the left.
            else {
                right = mid;
            }
        }
        
        // 'left' and 'right' converge at the index of a peak element
        return left;
    }
}
