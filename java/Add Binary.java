class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        // Pointers for the end of each string
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // Loop while there are digits left or a carry
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            if (i >= 0) {
                // char - '0' converts character '1' or '0' to integer 1 or 0
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // Append the bit (0 or 1)
            res.append(sum % 2);
            
            // Calculate new carry
            carry = sum / 2;
        }
        
        // The bits were added in reverse order, so we flip it back
        return res.reverse().toString();
    }
}
