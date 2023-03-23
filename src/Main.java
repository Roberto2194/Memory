package src;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int rows;
        int columns;

        System.out.println("\n****************************************");
        System.out.println("*************** WELCOME! ***************");
        System.out.println("****************************************\n");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please enter a valid board configuration");
            System.out.println("Remember that the total number of tiles must be even");
            System.out.println("And the board must have at lease 4 tiles\n");

            System.out.print("Number of rows: ");
            rows = input.nextInt();

            System.out.print("Number of columns: ");
            columns = input.nextInt();
        } while (!isConfigurationValid(rows, columns));

        // we can see the board as a simple matrix of rows and cols
        int[][] board = new int[rows][columns];

        System.out.print('\n');

        char[] symbols = makeSymbols(rows, columns);
        Card[] cards = createCards(symbols);

        shuffleCards(cards);

        // TODO: - we have to populate the "int[][] board" matrix with cards at every position.
        drawBoard(rows, columns, cards);

        System.out.print('\n');

        int firstCardRow;
        int firstCardColumn;
        int secondCardRow;
        int secondCardColumn;

        do {
            System.out.println("Please enter valid card values");
            System.out.println("First and second card must be different");
            System.out.println("Cards must be inside the boundaries of the board");
            System.out.println("Cards must NOT correspond to already reveled cards\n");

            System.out.print("First card - row: ");
            firstCardRow = input.nextInt();
            System.out.print("First card - column: ");
            firstCardColumn = input.nextInt();

            System.out.print("Second card - row: ");
            secondCardRow = input.nextInt();
            System.out.print("Second card - column: ");
            secondCardColumn = input.nextInt();
        } while (!areValuesValid(rows, columns, firstCardRow, firstCardColumn, secondCardRow, secondCardColumn));
    }

    /**
     * Creates as many symbols as tiles inside the board
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
     * Creates as many cards as the number of symbols given
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

    /**
     * Shuffles an array of cards putting them in a random order
     *
     * @param cards the cards that need to be shuffled
     */
    public static void shuffleCards(Card[] cards) {
        Random random = new Random();

        int i = 0;
        while (i < cards.length) {
            // Pick a random index
            int index = random.nextInt(cards.length);
            // Swap cards[i] with the element at random index
            Card temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
            i++;
        }
    }

    /**
     * Draws the board using the number of rows and columns stored
     *
     * @param rows    the number of rows in the board
     * @param columns the number of columns in the board
     * @param cards   the cards to be displayed inside every tile
     */
    public static void drawBoard(int rows, int columns, Card[] cards) {
        int cardNum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cards[cardNum].faceDown());
                cardNum++;
            }
            System.out.print("\n");
        }
    }

    /**
     * Checks whether the configuration that we get as an input
     * from the user is valid, otherwise we can not create the board.<br>
     * For the configuration to be valid we need at lest 4 tiles,
     * and if so, the total number of tiles must be even.
     *
     * @param rows    the number of rows
     * @param columns the number of columns
     * @return true or false based on whether the configuration is valid or not
     */
    public static boolean isConfigurationValid(int rows, int columns) {
        int tiles = rows * columns;
        if (tiles < 4) return false;
        return (tiles % 2 == 0);
    }

    /**
     * Checks whether the values that the user inserted for
     * rows and column are valid. That is:<br>
     * 1- first and second card must be different<br>
     * 2- cards must be inside the boundaries of the board;<br>
     * 3- cards must NOT correspond to already reveled cards.
     *
     * @param boardRows        the number of rows that the board has
     * @param boardColumns     the number of columns that the board has
     * @param firstCardRow     the row of the first card
     * @param firstCardColumn  the column of the first card
     * @param secondCardRow    the row of the second card
     * @param secondCardColumn the column of the second card
     * @return true or false based on whether the inserted one is a valid position or not
     */
    public static boolean areValuesValid(
            int boardRows,
            int boardColumns,
            int firstCardRow,
            int firstCardColumn,
            int secondCardRow,
            int secondCardColumn
    ) {
        // 1- first and second card must be different
        if (firstCardRow == secondCardRow && firstCardColumn == secondCardColumn) return false;
        // 2- are we inside the boundaries of the board
        if (firstCardRow > boardRows || firstCardColumn > boardColumns) return false;
        // 3- are the col and row inserted the ones of an already revealed card
        // TODO : - implement point number 3)
        return false;
    }


}
