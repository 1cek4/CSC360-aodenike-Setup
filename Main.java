public class Main {
    
    public static void main(String[] args) {
        NQueenFacade facade = new NQueenFacade(4);
        System.out.println(facade.Solve());
        //Or
        System.out.println(new NQueenFacade(4).Solve());

    }
}