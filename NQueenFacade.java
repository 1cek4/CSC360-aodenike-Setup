import java.util.ArrayList;
public class NQueenFacade {
    int n;
    int[][] board;
    ArrayList<ArrayList<String>> solutions;

    public NQueenFacade(int n) {
        this.n = n;
        this.board = new int[n][n];

    }

    public String Solve() {
        
        solutions = SortingLibrary.nQueen(n, 0, board);
        System.out.println("Number of solutions for " + n + " Queens: " + solutions.size());
        return solutions.toString();
    }
}