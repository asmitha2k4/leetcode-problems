class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            
            // Shift the accumulated result to the next higher digit placement level
            result = result * 26;
            
            // Convert character ('A' -> 1, 'B' -> 2...) and add it to the column total
            result += (c - 'A' + 1);
        }
        
        return result;
    }
}
