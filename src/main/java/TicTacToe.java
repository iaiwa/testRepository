import java.util.Scanner;

public class TicTacToe {
    private boolean xTurn;
    private Player player1;
    private Player player2;
    private GameBoard board;
    private Scanner sc;

    public TicTacToe(String playerName1, String playerName2) {

        this.player1 = new Player(playerName1, GameBoard.Mark.MARK_X);
        this.player2 = new Player(playerName2, GameBoard.Mark.MARK_0);
        xTurn = true;
        board = new GameBoard();
        sc = new Scanner(System.in);
    }

    private int[] getCoord() {
        int a = 0, b = 0;
        do {
            System.out.println("insert move location");
            a = sc.nextInt();
            b = sc.nextInt();
        } while (a < 1 || a > 3 || b < 1 || b > 3);
        return new int[]{a, b};
    }


    public void play() {
        while (!board.isGameOver()) {
            System.out.println(board);
            int[] coord = getCoord();
            boolean moveResult = board.move(coord, xTurn ?
                    GameBoard.Mark.MARK_X : GameBoard.Mark.MARK_0);
            if (moveResult) {
                xTurn = !xTurn;

            }
        }
        sc.close();
        if(board.isWinner(GameBoard.Mark.MARK_X))
        {
            System.out.println("Bravo "+ player1);
        }
        else if(board.isWinner(GameBoard.Mark.MARK_0)){
            System.out.println("Bravo "+ player2);
        }else
            System.out.println("nimeni nu a castigat");

    }
}
