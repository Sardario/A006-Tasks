public class P000_Z03 {

    static final int SIZE = 8;
    static int[] queenColumn = new int[SIZE];

    /**
     * Checks whether a queen can be placed at (row, col).
     */
    public static boolean isSafe(int row, int col) {
        for (int previousRow = 0; previousRow < row; previousRow++) {
            int previousCol = queenColumn[previousRow];

            // Same column
            if (previousCol == col) {
                return false;
            }

            // Same diagonal
            if (Math.abs(previousCol - col) == Math.abs(previousRow - row)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Solves the 8 Queens problem using backtracking.
     */
    public static boolean solve(int row) {
        if (row == SIZE) {
            return true; // all queens are placed
        }

        for (int col = 0; col < SIZE; col++) {
            if (isSafe(row, col)) {
                queenColumn[row] = col;

                if (solve(row + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Prints the chessboard.
     */
    public static void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (queenColumn[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (solve(0)) {
            System.out.println("One valid solution:");
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
