package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = input.nextInt();

        System.out.print("Number of columns: ");
        int columns = input.nextInt();

        char[] symbols = makeSymbols(rows, columns);
        Card[] cards = createCards(symbols);

        Board<Card> board = new Board<>(rows, columns, cards);

        if (board.isConfigurationEven()) {
            board.drawBoard();
        }

        System.out.print("Enter pair to reveal: ");
        String pair = input.nextLine();

        //           (row,col)          (row,col)
        // first card: (2,1) second card: (3,2)

    }

    public static char[] makeSymbols(int rows, int columns) {
        // characters from 33 to 126 (126-33=94*2=188)
        char[] symbols = new char[rows * columns];

        // we add two of the same symbol to the array
        // this is going to help us when we create the cards
        for (int i = 0; i < symbols.length; i = i + 2) {
            // ASCII code for first symbol is 33
            symbols[i] = (char) (i + 33);
            symbols[i + 1] = (char) (i + 33);
        }

        return symbols;
    }

    public static Card[] createCards(char[] symbols) {
        Card[] cards = new Card[symbols.length];

        int i = 0;
        while (i < symbols.length) {
            cards[i] = new Card(symbols[i]);
            i++;
        }

        return cards;
    }

}
