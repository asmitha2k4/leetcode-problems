class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = version1.length();
        int n2 = version2.length();
        
        // Loop until both version strings are completely parsed
        while (i < n1 || j < n2) {
            int num1 = 0;
            int num2 = 0;
            
            // Parse the current revision block for version1
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            
            // Parse the current revision block for version2
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            
            // Compare the converted integer values of the current revisions
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            
            // Move pointers past the dot '.' character
            i++;
            j++;
        }
        
        // If all revisions match up to the end, the versions are equal
        return 0;
    }
}
