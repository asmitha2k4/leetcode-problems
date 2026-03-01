class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // if current index is beyond farthest reachable, can't proceed
            if (i > farthest) return false;
            
            // update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        // if loop completes, last index is reachable
        return true;
    }
}
