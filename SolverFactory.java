public class SolverFactory {
    public enum SolverType {
        BACKTRACKING,
        BITMASKING,
        CONSTRAINT_PROPAGATION
    }
    public static NQueensSolver makeSolver(SolverType type){
        switch(type){
            case BACKTRACKING:
                return new BacktrackSolver();
            case BITMASKING:
                return new BitmaskingSolver();
            default:
                throw new IllegalArgumentException("Invalid solver type");
        }
    }
    
} 