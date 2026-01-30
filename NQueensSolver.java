import java.util.ArrayList;

public abstract class NQueensSolver {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public abstract ArrayList<ArrayList<String>> nQueen(int n, int row, int board[][], ArrayList<ArrayList<String>> result);

    public ArrayList<ArrayList<String>> nQueenStarter(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<ArrayList<String>> solutions = nQueen(n, 0,board, result);
        System.out.println(solutions.size() + "solution(s) found.");
        return solutions;
    }
}
