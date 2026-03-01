class Solution {
    
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while(left < right) {
            
            int width = right - left;
            int minHeight;
            
            if(height[left] < height[right]) {
                minHeight = height[left];
                left++;
            } else {
                minHeight = height[right];
                right--;
            }
            
            int currentWater = width * minHeight;
            
            if(currentWater > maxWater) {
                maxWater = currentWater;
            }
        }
        
        return maxWater;
    }
}
