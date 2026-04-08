import java.util.Arrays;

public class P000_M03 {

    /**
     * Finds the sum of three numbers that is closest to target.
     * If two sums have the same distance to target, the smaller sum is chosen.
     * Uses sorting + two pointers: O(n^2).
     */
    public static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);

        int n = array.length;
        int bestSum = array[0] + array[1] + array[2];
        int bestDiff = Math.abs(bestSum - target);

        // Fix the first element, then search for the best pair
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                int diff = Math.abs(sum - target);

                // Update the best answer:
                // 1) smaller difference is better
                // 2) if difference is the same, smaller sum is better
                if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                    bestDiff = diff;
                    bestSum = sum;
                }

                // Move pointers based on comparison with target
                if (sum < target) {
                    left++;   // need a larger sum
                } else if (sum > target) {
                    right--;  // need a smaller sum
                } else {
                    // Exact match is the best possible answer
                    return sum;
                }
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {-1, 2, 1, -4},
                {10, 20, 30, 40},
                {0, 0, 0, 1},
                {-5, -2, 7, 9}
        };

        int[] targets = {10, 1, 55, 2, 3};

        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("S=%d -> %d%n",
                    targets[i],
                    threeSumClosest(arrays[i], targets[i]));
        }
    }
}
