import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            int currentMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Reduce the fraction using Greatest Common Divisor (GCD)
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Normalize the signs so (-1, 2) and (1, -2) are identical
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                // Create a unique string key for the irreducible slope
                String slope = dx + "," + dy;
                slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopes.get(slope));
            }

            // Total points on this line includes the starting anchor point 'i'
            maxPoints = Math.max(maxPoints, currentMax + 1);
        }

        return maxPoints;
    }

    // Helper method to find the greatest common divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
