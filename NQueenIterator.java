import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class NQueenIterator implements Iterator<ArrayList<String>> {

    int n;
    int[][] board;
    Stack<Integer> columnStack;
    boolean hasNext;
    ArrayList<String> nextSolution;

    public NQueenIterator(int n) {
        this.n = n;
        this.board = new int[n][n];
        this.columnStack = new Stack<>();
        this.hasNext = true;
        this.nextSolution = null;
    }

    @Override 
    public boolean hasNext() {
        if (nextSolution == null) {
            nextSolution = findNextSolution();
        }
        return nextSolution != null;
    }
    @Override
    public ArrayList<String> next() {
        if (nextSolution == null) {
            nextSolution = findNextSolution();
        }
        ArrayList<String> result = nextSolution;
        nextSolution = null;
        return result;
    }

    public ArrayList<String> findNextSolution(){
         while (true) {
            int currentRow = columnStack.size() - 1;
            
            if (currentRow < 0) {
                return null;
            }
            
            if (currentRow == n) {
                ArrayList<String> solution = new ArrayList<>();
                for (int[] boardRow : board) {
                    StringBuilder sb = new StringBuilder();
                    for (int val : boardRow) {
                        sb.append(val == 1 ? "Q" : ".");
                    }
                    solution.add(sb.toString());
                }
                
                backtrack();
                
                return solution;
            }
            
            int lastColumn = columnStack.pop();
            int nextColumn = lastColumn + 1;
            
            boolean placedQueen = false;
            for (int col = nextColumn; col < n; col++) {
                Queen queen = new Queen(new int[]{currentRow, col});
                if (isSafeToPlace(queen, board)) {
                   
                    board[currentRow][col] = 1;
                    columnStack.push(col);
                    columnStack.push(-1);
                    placedQueen = true;
                    break;
                }
            }
            
            if (!placedQueen) {
                if (currentRow == 0) {
                    return null;
                }
                backtrack();
            }
        }
    }
    
    private void backtrack() {
        if (!columnStack.isEmpty()) {
            columnStack.pop();
        }
        
        if (!columnStack.isEmpty()) {
            int prevRow = columnStack.size() - 1;
            int prevCol = columnStack.peek();
            if (prevRow >= 0 && prevCol >= 0 && prevRow < n && prevCol < n) {
                board[prevRow][prevCol] = 0;
            }
        }
    }
    
    private static boolean isSafeToPlace(Queen queen, int[][] board) {
        int row = queen.position[0];
        int column = queen.position[1];
        int n = board.length;

        for (int i = 0; i < row; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    


}
