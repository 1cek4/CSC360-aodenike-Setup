import java.util.ArrayList;
import java.util.Iterator;

public class NQueenSolver implements Iterable<ArrayList<String>> {
    private int n;

    public NQueenSolver(int n) {
        this.n = n;
    }

    @Override
    public Iterator<ArrayList<String>> iterator() {
        return new NQueenIterator(n);
    }

    public static void main(String[] args) {
        NQueenSolver solver = new NQueenSolver(4);

        int count = 0;
        for (ArrayList<String> solution : solver) {
            count++;
            System.out.println("Solution " + count + ":");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        System.out.println("Total solutions: " + count);
    }
}