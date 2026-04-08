public class P000_E01 {

    /**
     * Counts the number of digits in an integer.
     * param n input number
     * return number of digits
     */
    public static int countDigits(int n) {
        // Special case: 0 has 1 digit
        if (n == 0) {
            return 1;
        }

        int count = 0;
        n = Math.abs(n); // handle negative numbers

        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 7, 42, 1000, -987654};

        for (int number : testNumbers) {
            System.out.printf("%d -> %d%n", number, countDigits(number));
        }
    }
}