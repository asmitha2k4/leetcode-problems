class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            // If count reaches 0, we select a new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // If current number matches our candidate, increment count
            // Otherwise, decrement count to simulate a "vote cancellation"
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
