class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Treat the 2D matrix as a 1D array of length m * n
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Map the 1D 'mid' index back to 2D coordinates [row][col]
            int row = mid / n;
            int col = mid % n;
            
            int val = matrix[row][col];
            
            if (val == target) {
                return true;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
