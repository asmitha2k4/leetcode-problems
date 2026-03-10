class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a Red: Swap it to the front
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Found a White: It's in the right place for now
                mid++;
            } else {
                // Found a Blue (2): Swap it to the end
                swap(nums, mid, high);
                high--;
                // Note: We don't increment mid here because the new element
                // swapped from 'high' hasn't been checked yet.
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
