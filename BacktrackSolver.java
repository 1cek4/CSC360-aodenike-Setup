import java.util.ArrayList;

public class BacktrackSolver extends NQueensSolver{
    public  ArrayList<ArrayList<String>> nQueen(int n, int row, int[][] board,ArrayList<ArrayList<String>> result) {
        //This program should itterate through every row,
        //attempt to place a queen in the current row and column then check if its okay to stay there
        //if its okay to place there add it to the board an int[][] , then call itself again but pass in an increased row
        //if its not go back and change the previous queens position, which will call itself again
        //after we reach the last row return the solutions found
        //to check if a spot is safe make sure it doesnt share and x or y with the new queen, then check diagonals

        //Big o is probably O((N(Log(N)^2) + n^2)) i feel like this is wrong but i do think i have the pieces correct

        if (row == n) {
            ArrayList<String> solution = new ArrayList<>();
            for (int[] boardRow : board) { //O(N)
                StringBuilder sb = new StringBuilder();
                for (int val : boardRow) {//O(N)
                    sb.append(val == 1 ? "Q" : ".");
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return result;
        }

        for (int column = 0; column < n; column++) { //O(N)
            Queen queen = new Queen(new int[]{row, column});
            if (isSafeToPlace(queen, board)) { //n (isSafeToPlace)
                board[row][column] = 1;
                nQueen(n, row + 1, board, result);
                board[row][column] = 0;
            }
        }
        return result;
    }

    public  boolean isSafeToPlace(Queen queen, int[][] board) {
        int row = queen.position[0];
        int column = queen.position[1];
        int n = board.length;

        for (int i = 0; i < row; i++) { //O(N)
            if (board[i][column] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) { //O(N)
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) { //O(N)
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}