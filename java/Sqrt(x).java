class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // Handle 0 and 1 immediately
        
        int left = 1;
        int right = x / 2; // The square root of x (where x > 1) is never more than x/2
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow compared to (left + right) / 2
            
            // Check if mid * mid == x, but use division to avoid integer overflow
            if (mid <= x / mid) {
                result = mid; // This could be the answer, so save it
                left = mid + 1; // Try to find a larger value
            } else {
                right = mid - 1; // Too high, look in the lower half
            }
        }
        
        return result;
    }
}
