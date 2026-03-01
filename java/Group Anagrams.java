import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort the string to get the key
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
