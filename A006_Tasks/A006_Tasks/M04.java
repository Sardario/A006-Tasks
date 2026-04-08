public class P000_M04 {

    /**
     * Finds the maximum sum of a contiguous subarray.
     * Uses Kadane's Algorithm (O(n)).
     */
    public static int maxSubarraySum(int[] array) {

        int maxSoFar = array[0];   // best result found so far
        int currentSum = array[0]; // current subarray sum

        for (int i = 1; i < array.length; i++) {

            // Either extend the current subarray or start a new one
            currentSum = Math.max(array[i], currentSum + array[i]);

            // Update global maximum
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, -2, 3, 4, -1},
                {-5, -1, -8},
                {5, 4, 3},
                {2, -1, 2, -1, 2},
                {0, 0, 0}
        };

        for (int[] arr : tests) {
            System.out.println(maxSubarraySum(arr));
        }
    }
}
