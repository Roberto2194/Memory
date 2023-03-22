package src;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int rows;
        int columns;

        System.out.print("Number of rows: ");
        rows = input.nextInt();

        System.out.print("Number of columns: ");
        columns = input.nextInt();

        while (!isConfigurationEven(rows, columns)) {
            System.out.println("The number of tiles must be even");
            System.out.println("Please enter a valid board configuration");

            System.out.print("Number of rows: ");
            rows = input.nextInt();

            System.out.print("Number of columns: ");
            columns = input.nextInt();
        }

        char[] symbols = makeSymbols(rows, columns);
        Card[] cards = createCards(symbols);
        shuffleCards(cards);

        Board board = new Board(rows, columns, cards);
        board.drawBoard();

        System.out.print("Enter pair to reveal: ");
        String pair = input.nextLine();

        //           (row,col)          (row,col)
        // first card: (2,1) second card: (3,2)
    }

    /**
     * creates as many symbols as tiles inside the board
     * the number of tiles is given by rows*columns
     *
     * @param rows    the number of rows
     * @param columns the number of columns
     * @return the array of symbols created
     */
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

    /**
     * creates as many cards as the number of symbols given
     *
     * @param symbols the array of symbols
     * @return the array of cards created
     */
    public static Card[] createCards(char[] symbols) {
        Card[] cards = new Card[symbols.length];

        int i = 0;
        while (i < symbols.length) {
            cards[i] = new Card(symbols[i]);
            i++;
        }

        return cards;
    }

    // TODO: - Needs to be fixed
    public static void shuffleCards(Card[] cards) {
        List<Card> cardList = Arrays.asList(cards);

        for (int i = 0; i < cards.length; i++) {
            int index = new Random().nextInt(cardList.size());
            cardList.get(index);
        }
    }

    /**
     * Checks whether the configuration that we get as an input
     * from the user is even, otherwise we can not create the board
     *
     * @param rows the number of rows
     * @param columns the number of columns
     * @return true or false based on whether the configuration is even or not
     */
    public static boolean isConfigurationEven(int rows, int columns) {
        return (rows * columns % 2 == 0);
    }

}
