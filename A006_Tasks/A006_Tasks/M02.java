import java.util.Arrays;

public class P000_M02 {

    /**
     * Counts the number of triples (i < j < k)
     * such that array[i] + array[j] + array[k] == target.
     * Uses sorting + two pointers (O(n^2)).
     */
    public static int threeSumCount(int[] array, int target) {
        Arrays.sort(array); // Step 1: sort the array

        int n = array.length;
        int count = 0;

        // Step 2: fix the first element
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;      // second element
            int right = n - 1;     // third element

            // Step 3: two-pointer search
            while (left < right) {

                int sum = array[i] + array[left] + array[right];

                if (sum == target) {

                    // Case 1: all elements between left and right are equal
                    if (array[left] == array[right]) {
                        int len = right - left + 1;

                        // number of ways to pick 2 elements from len items
                        count += len * (len - 1) / 2;
                        break;
                    }

                    // Case 2: count duplicates on the left side
                    int leftCount = 1;
                    while (left + 1 < right && array[left] == array[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    // Case 3: count duplicates on the right side
                    int rightCount = 1;
                    while (right - 1 > left && array[right] == array[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    // multiply combinations from both sides
                    count += leftCount * rightCount;

                    // move both pointers
                    left++;
                    right--;

                } else if (sum < target) {
                    // need a bigger sum → move left forward
                    left++;
                } else {
                    // need a smaller sum → move right backward
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0},
                {-1, 0, 1, 2, -2},
                {5, 5, 5, 5, 5},
                {2, 2, 2, 2}
        };

        int[] targets = {9, 0, 0, 15, 6};

        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("S=%d -> %d%n",
                    targets[i],
                    threeSumCount(arrays[i], targets[i]));
        }
    }
}
