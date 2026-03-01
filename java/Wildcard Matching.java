class Solution {
    
    public boolean isMatch(String s, String p) {
        
        int i = 0;          // pointer for s
        int j = 0;          // pointer for p
        int starIndex = -1; 
        int match = 0;
        
        while(i < s.length()) {
            
            // Case 1: characters match or '?'
            if(j < p.length() &&
               (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                
                i++;
                j++;
            }
            
            // Case 2: '*'
            else if(j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                match = i;
                j++;
            }
            
            // Case 3: mismatch but previous '*' exists
            else if(starIndex != -1) {
                j = starIndex + 1;
                match++;
                i = match;
            }
            
            // Case 4: no match
            else {
                return false;
            }
        }
        
        // Check remaining pattern characters
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}
