public class P000_M01 {

    /**
     * Checks if there exist three indices i < j < k
     * such that a[i] + a[j] + a[k] == target.
     */
    public static boolean threeSumExists(int[] array, int target) {
        int n = array.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    int sum = array[i] + array[j] + array[k];

                    if (sum == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {1, 2, 3, 4, 5},
                {-1, 0, 1, 2, -2},
                {10, 20, 30},
                {5, 5, 5, 5},
                {3, 7, 9, 2}
        };

        int[] targets = {9, 0, 60, 16, 100};

        for (int i = 0; i < testArrays.length; i++) {
            System.out.printf("S=%d -> %b%n",
                    targets[i],
                    threeSumExists(testArrays[i], targets[i]));
        }
    }
}
