import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) targetCount[c]++;

        int[] windowCount = new int[128];
        int left = 0, right = 0;
        int required = t.length(); // Total characters we need to match
        int formed = 0;           // Characters currently matched in window
        
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount[c]++;
            
            // If current char is needed and we haven't exceeded the count in t
            if (targetCount[c] > 0 && windowCount[c] <= targetCount[c]) {
                formed++;
            }

            // When the window is valid, try to shrink it
            while (formed == required) {
                // Update minimum window details
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;
                
                // If removing this char makes the window invalid
                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
