public class P000_Z02 {

    static final int SIZE = 4;
    static final int BOX_SIZE = 2;

    static int[][] grid = {
            {1, 0, 0, 4},
            {0, 0, 1, 0},
            {0, 3, 0, 0},
            {2, 0, 0, 3}
    };

    /**
     * Checks whether a value can be placed at grid[row][col].
     */
    public static boolean isValid(int row, int col, int value) {
        // Check the row
        for (int j = 0; j < SIZE; j++) {
            if (grid[row][j] == value) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][col] == value) {
                return false;
            }
        }

        // Check the 2x2 subgrid
        int boxRowStart = (row / BOX_SIZE) * BOX_SIZE;
        int boxColStart = (col / BOX_SIZE) * BOX_SIZE;

        for (int i = boxRowStart; i < boxRowStart + BOX_SIZE; i++) {
            for (int j = boxColStart; j < boxColStart + BOX_SIZE; j++) {
                if (grid[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Solves the Sudoku using backtracking.
     */
    public static boolean solve(int position) {
        if (position == SIZE * SIZE) {
            return true; // all cells are processed
        }

        int row = position / SIZE;
        int col = position % SIZE;

        // Skip already filled cells
        if (grid[row][col] != 0) {
            return solve(position + 1);
        }

        // Try values from 1 to 4
        for (int value = 1; value <= SIZE; value++) {
            if (isValid(row, col, value)) {
                grid[row][col] = value;

                if (solve(position + 1)) {
                    return true;
                }

                // Undo the move if it does not lead to a solution
                grid[row][col] = 0;
            }
        }

        return false;
    }

    /**
     * Prints the Sudoku grid.
     */
    public static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (solve(0)) {
            System.out.println("Solved Sudoku:");
            printGrid();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
