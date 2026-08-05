import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Base case: if numerator is 0, the answer is always "0"
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        
        // Handle negative signs cleanly. Use long to prevent integer overflow (e.g., -2^31)
        if ((numerator < 0) ^ (denominator < 0)) {
            res.append("-");
        }
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Step 1: Calculate the integral (whole number) part
        res.append(num / den);
        long remainder = num % den;
        
        // If there is no fractional part, return early
        if (remainder == 0) {
            return res.toString();
        }
        
        // Step 2: Append the decimal point
        res.append(".");
        
        // Map to store seen remainders and their respective string indices
        Map<Long, Integer> remainderMap = new HashMap<>();
        
        // Step 3: Simulate long division for the fractional part
        while (remainder != 0) {
            // If the remainder has been seen before, a repeating cycle is detected
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            
            // Record the current remainder and its position before modifying it
            remainderMap.put(remainder, res.length());
            
            // Multiply remainder by 10 to simulate bringing down a zero
            remainder *= 10;
            res.append(remainder / den);
            remainder %= den;
        }
        
        return res.toString();
    }
}
