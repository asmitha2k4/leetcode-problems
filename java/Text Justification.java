import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int lineLength = words[i].length();
            int last = i + 1;
            
            // 1. Pack as many words as possible
            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > maxWidth) break;
                lineLength += 1 + words[last].length();
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numWords = last - i;
            
            // 2. If it's the last line or only one word in the line -> Left Justify
            if (last == words.length || numWords == 1) {
                for (int k = i; k < last; k++) {
                    sb.append(words[k]);
                    if (k < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // 3. Fully Justify
            else {
                int totalSpaces = maxWidth - (lineLength - (numWords - 1));
                int spaceBetween = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                
                for (int k = i; k < last; k++) {
                    sb.append(words[k]);
                    if (k < last - 1) {
                        int spacesToAdd = spaceBetween + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) sb.append(" ");
                    }
                }
            }
            
            result.add(sb.toString());
            i = last; // Move to the next set of words
        }
        
        return result;
    }
}
