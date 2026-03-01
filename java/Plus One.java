class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // increment if less than 9
                return digits; // no carry, done
            }
            digits[i] = 0; // set to 0 and carry 1 to the next digit
        }
        
        // If all digits were 9, we need a new array with extra digit
        int[] result = new int[n + 1];
        result[0] = 1; // the rest are 0 by default
        return result;
    }
}
