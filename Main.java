import java.util.ArrayList;

public class Main{
    
    public static void main(String[] args) {
        int n = 4;

        // Choose solver from args: "bitmask" will use the bitmasking solver, otherwise default to backtracking.
        NQueensSolver solver = SolverFactory.makeSolver(
            (args.length > 0 && "bitmask".equalsIgnoreCase(args[0])) ? SolverFactory.SolverType.BITMASKING : SolverFactory.SolverType.BACKTRACKING
        );

        ArrayList<ArrayList<String>> solutions = solver.nQueenStarter(n);
        System.out.println(solutions);
        
    }
}
