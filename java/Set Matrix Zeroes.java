class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstColZero = false;

        for (int i = 0; i < rows; i++) {
            // Check if the first column should be zeroed later
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
            
            // Use the first row and column to store markers
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Iterate backwards to avoid overwriting the markers too early
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // Finally, zero the first column if needed
            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
