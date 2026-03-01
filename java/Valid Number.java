class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        
        s = s.trim(); // remove leading/trailing spaces
        
        boolean numSeen = false;    // at least one digit before e
        boolean dotSeen = false;    // decimal point
        boolean eSeen = false;      // exponent
        
        boolean numAfterE = true;   // digits after 'e'
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                numSeen = true;
                if (eSeen) numAfterE = true;
            } else if (c == '.') {
                if (dotSeen || eSeen) return false; // only one dot, and no dot after e
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) return false; // only one e, must have a number before
                eSeen = true;
                numAfterE = false; // reset for digits after e
            } else if (c == '+' || c == '-') {
                // sign is valid only at the beginning or right after e
                if (i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
            } else {
                return false; // invalid character
            }
        }
        
        return numSeen && numAfterE;
    }
}
