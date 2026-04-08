public class P000_Z01 {

    static final boolean[] usedDigits = new boolean[10];

    static int S, E, N, D, M, O, R, Y;

    /**
     * Builds a 4-digit number from digits.
     */
    public static int make4DigitNumber(int a, int b, int c, int d) {
        return a * 1000 + b * 100 + c * 10 + d;
    }

    /**
     * Solves the cryptarithm:
     *   SEND
     * + MORE
     * = MONEY
     */
    public static void solve() {
        for (S = 1; S <= 9; S++) {
            usedDigits[S] = true;

            for (E = 0; E <= 9; E++) {
                if (usedDigits[E]) continue;
                usedDigits[E] = true;

                for (N = 0; N <= 9; N++) {
                    if (usedDigits[N]) continue;
                    usedDigits[N] = true;

                    for (D = 0; D <= 9; D++) {
                        if (usedDigits[D]) continue;
                        usedDigits[D] = true;

                        for (M = 1; M <= 9; M++) {
                            if (usedDigits[M]) continue;
                            usedDigits[M] = true;

                            for (O = 0; O <= 9; O++) {
                                if (usedDigits[O]) continue;
                                usedDigits[O] = true;

                                for (R = 0; R <= 9; R++) {
                                    if (usedDigits[R]) continue;
                                    usedDigits[R] = true;

                                    for (Y = 0; Y <= 9; Y++) {
                                        if (usedDigits[Y]) continue;

                                        int send = make4DigitNumber(S, E, N, D);
                                        int more = make4DigitNumber(M, O, R, E);
                                        int money = M * 10000 + O * 1000 + N * 100 + E * 10 + Y;

                                        if (send + more == money) {
                                            System.out.println("Solution found:");
                                            System.out.println("S=" + S + ", E=" + E + ", N=" + N + ", D=" + D +
                                                    ", M=" + M + ", O=" + O + ", R=" + R + ", Y=" + Y);
                                            System.out.println(send + " + " + more + " = " + money);
                                            return;
                                        }
                                    }

                                    usedDigits[R] = false;
                                }

                                usedDigits[O] = false;
                            }

                            usedDigits[M] = false;
                        }

                        usedDigits[D] = false;
                    }

                    usedDigits[N] = false;
                }

                usedDigits[E] = false;
            }

            usedDigits[S] = false;
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
