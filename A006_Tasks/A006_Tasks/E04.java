public class P000_E04 {

    /**
     * Reverses a positive integer.
     */
    public static int reversePositive(int n) {
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }

        return reversed;
    }

    /**
     * Checks if a number is a palindrome.
     */
    public static boolean isPalindromeNumber(int n) {
        if (n < 0) {
            return false; // negative numbers are not palindrome
        }

        return n == reversePositive(n);
    }

    public static void main(String[] args) {
        int[] testNumbers = {0, 7, 11, 121, 123, -121, 1001, 120};

        for (int number : testNumbers) {
            System.out.printf("%d -> %b%n", number, isPalindromeNumber(number));
        }
    }
}