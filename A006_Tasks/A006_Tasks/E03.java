public class P000_E03 {

    /**
     * Reverses the digits of an integer.
     * @param n input number
     * @return reversed number
     */
    public static int reverseNumber(int n) {
        int sign = (n < 0) ? -1 : 1;
        n = Math.abs(n);

        int reversed = 0;

        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return reversed * sign;
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 7, 42, 120, -507};

        for (int number : testNumbers) {
            System.out.printf("%d -> %d%n", number, reverseNumber(number));
        }
    }
}