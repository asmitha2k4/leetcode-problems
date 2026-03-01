import java.util.*;

class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        backtrack(digits, 0, "", result, map);
        
        return result;
    }
    
    public void backtrack(String digits, int index, String current,
                          List<String> result, String[] map) {
        
        if(index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = map[digits.charAt(index) - '0'];
        
        for(int i = 0; i < letters.length(); i++) {
            backtrack(digits, index + 1, 
                      current + letters.charAt(i), 
                      result, map);
        }
    }
}
