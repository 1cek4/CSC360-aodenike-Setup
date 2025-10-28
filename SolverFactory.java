public class SolverFactory {
    public enum SolverType {
        BACKTRACKING
    }
    public static NQueensSolver makeSolver(SolverType type){
        switch(type){
            case BACKTRACKING:
                return new BacktrackSolver();
            default:
                throw new IllegalArgumentException("Invalid solver type");
        }
    }
    
} 