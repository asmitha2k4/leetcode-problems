class Solution {
    
    public int myAtoi(String s) {
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading spaces
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Check sign
        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        
        int result = 0;
        
        // Step 3: Convert digits
        while(i < n && Character.isDigit(s.charAt(i))) {
            
            int digit = s.charAt(i) - '0';
            
            // Step 4: Check overflow
            if(result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}
