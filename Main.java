import java.util.ArrayList;

public class Main{
    
    public static void main(String[] args) {
        int n = 4;

        NQueensSolver solver = SolverFactory.makeSolver(SolverFactory.SolverType.BACKTRACKING);

        ArrayList<ArrayList<String>> solutions = solver.nQueenStarter(n);
        System.out.println(solutions);
        
    }
}
