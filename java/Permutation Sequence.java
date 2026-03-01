class Solution {
    public String getPermutation(int n, int k) {
        // Step 1: Precompute factorials
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // Step 2: Initialize numbers list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Step 3: Build permutation
        StringBuilder sb = new StringBuilder();
        k--; // convert to 0-indexed
        for (int i = n; i >= 1; i--) {
            int idx = k / factorial[i - 1];   // determine index for current digit
            sb.append(numbers.get(idx));
            numbers.remove(idx);               // remove used number
            k = k % factorial[i - 1];          // update k for next position
        }
        
        return sb.toString();
    }
}
