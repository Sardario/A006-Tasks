public class P000_E02 {

    /**
     * Computes the sum of digits of an integer.
     * @param n input number
     * @return sum of digits
     */
    public static int digitSum(int n) {
        n = Math.abs(n); // handle negative numbers
        int sum = 0;

        while (n > 0) {
            sum += n % 10; // take last digit
            n /= 10;       // remove last digit
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 7, 42, 1000, -987654};

        for (int number : testNumbers) {
            System.out.printf("%d -> %d%n", number, digitSum(number));
        }
    }
}