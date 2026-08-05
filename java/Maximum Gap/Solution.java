import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // Step 1: Find the minimum and maximum values in the array
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // If all elements are identical, the maximum gap is 0
        if (minVal == maxVal) {
            return 0;
        }

        int n = nums.length;

        // Step 2: Calculate bucket size and number of buckets
        // The minimum possible maximum gap (average gap) is ceil((max - min) / (n - 1))
        int bucketSize = (int) Math.ceil((double) (maxVal - minVal) / (n - 1));
        int numBuckets = (maxVal - minVal) / bucketSize + 1;

        // Arrays to store the min and max values within each bucket
        int[] bucketMin = new int[numBuckets];
        int[] bucketMax = new int[numBuckets];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Step 3: Populate the buckets
        for (int num : nums) {
            int bucketIdx = (num - minVal) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // Step 4: Scan buckets to find the maximum gap
        int maxGap = 0;
        int previousMax = minVal; // Tracks the max value of the previous non-empty bucket

        for (int i = 0; i < numBuckets; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            // The gap is the difference between current bucket's min and previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
