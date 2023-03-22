package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card("!", "X");
        Card card2 = new Card("%", "X");

        Scanner input = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = input.nextInt();

        System.out.print("Number of columns: ");
        int columns = input.nextInt();

        Board board = new Board(rows, columns);

        if (board.isConfigurationEven(board.getRows(), board.getColumns())) {
            board.drawBoard(board.getRows(), board.getColumns());
        }
    }

}
