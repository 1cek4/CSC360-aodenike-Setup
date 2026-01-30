import java.util.ArrayList;

public class BitmaskingSolver extends NQueensSolver {

    @Override
    public ArrayList<ArrayList<String>> nQueen(int n, int row, int[][] board, ArrayList<ArrayList<String>> result) {
        // Start the bitmask-based recursion. We use long bitmasks to support up to 63/64 columns.
        solve(n, 0, board, result, 0L, 0L, 0L);
        return result;
    }

    /**
     * Recursively place queens using bitmasks for columns, diagonals-left (diag1) and diagonals-right (diag2).
     * @param n Board size
     * @param row Current row
     * @param board Grid to store queens for human-readable output
     * @param result All valid solutions collected here
     * @param cols Bitmask of occupied columns
     * @param diag1 Bitmask of occupied "left" diagonals shifted for the next row (col << 1)
     * @param diag2 Bitmask of occupied "right" diagonals shifted for the next row (col >> 1)
     */
    private void solve(int n, int row, int[][] board, ArrayList<ArrayList<String>> result, long cols, long diag1, long diag2) {
        if (row == n) {
            // build solution from board and add to result
            ArrayList<String> solution = new ArrayList<>();
            for (int[] r : board) {
                StringBuilder sb = new StringBuilder();
                for (int val : r) {
                    sb.append(val == 1 ? "Q" : ".");
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }

        long allOnes = (1L << n) - 1L;
        long availablePositions = allOnes & ~(cols | diag1 | diag2);

        while (availablePositions != 0L) {
            // Get the rightmost available position
            long position = availablePositions & -availablePositions;
            int colIndex = Long.numberOfTrailingZeros(position);

            // Place queen in board representation
            board[row][colIndex] = 1;

            // Recurse to next row with updated masks:
            // - cols: mark this column as used
            // - diag1: mark left diagonal (shift left by 1 for the next row)
            // - diag2: mark right diagonal (shift right by 1 for the next row)
            solve(n, row + 1, board, result, cols | position, (diag1 | position) << 1, (diag2 | position) >> 1);

            // Backtrack
            board[row][colIndex] = 0;

            // Remove the position from availablePositions
            availablePositions &= (availablePositions - 1L);
        }
    }

}
// End of BitmaskingSolver
