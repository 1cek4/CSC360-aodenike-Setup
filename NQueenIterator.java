import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class NQueenIterator implements Iterator<ArrayList<String>> {

    private final int n;
    private final int[] columns; 
    private int currentRow;
    private boolean finished;
    private ArrayList<String> nextSolution;

    public NQueenIterator(int n) {
        this.n = n;
        this.columns = new int[n];
        Arrays.fill(this.columns, -1);
        this.currentRow = 0;
        this.finished = false;
        this.nextSolution = null;
    }

    @Override
    public boolean hasNext() {
        if (nextSolution != null) return true;
        if (finished) return false;
        nextSolution = findNextSolution();
        if (nextSolution == null) finished = true;
        return nextSolution != null;
    }

    @Override
    public ArrayList<String> next() {
        if (!hasNext()) return null;
        ArrayList<String> r = nextSolution;
        nextSolution = null;
        return r;
    }

    private ArrayList<String> findNextSolution() {
        while (currentRow >= 0) {
            columns[currentRow]++;

            while (columns[currentRow] < n && !isSafeToPlace(currentRow, columns[currentRow])) {
                columns[currentRow]++;
            }

            if (columns[currentRow] < n) {
                if (currentRow == n - 1) {
                    ArrayList<String> solution = buildSolution();
                    return solution;
                } else {
                    currentRow++;
                    columns[currentRow] = -1;
                }
            } else {
                columns[currentRow] = -1;
                currentRow--;
            }
        }

        return null; 
    }

    private ArrayList<String> buildSolution() {
        ArrayList<String> sol = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                sb.append(columns[r] == c ? 'Q' : '.');
            }
            sol.add(sb.toString());
        }
        return sol;
    }

    private boolean isSafeToPlace(int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = columns[r];
            if (c == col) return false;
            if (Math.abs(r - row) == Math.abs(c - col)) return false; 
        }
        return true;
    }
}


