package src;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int rows;
        int columns;
        int flipCounter;

        System.out.println("\n************************************************************");
        System.out.println("********************** W E L C O ME ! **********************");
        System.out.println("************************************************************\n");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("************************************************************");
            System.out.println("***       Please enter a valid board configuration       ***");
            System.out.println("*** Remember that the total number of tiles must be even ***");
            System.out.println("***       And the board must have at least 4 tiles       ***");
            System.out.println("************************************************************\n");

            System.out.print("Number of rows: ");
            rows = input.nextInt();

            System.out.print("Number of columns: ");
            columns = input.nextInt();

            System.out.print('\n');
        } while (!isConfigurationValid(rows, columns));

        // we can see the board as a simple matrix of Cards
        Card[][] board = new Card[rows][columns];

        char[] symbols = makeSymbols(rows, columns);
        Card[] cards = createCards(symbols);

        shuffleCards(cards);
        addCardsToBoard(board, cards);

        //Draw the board here with all cards face down
        drawBoard(board);

        int firstCardRow;
        int firstCardColumn;
        int secondCardRow;
        int secondCardColumn;

        do {
            System.out.println("\n*************************************************************");
            System.out.println("***      Please select the two cards you want to flip:    ***");
            System.out.println("***       1- First and second card must be different      ***");
            System.out.println("***  2- Cards must be inside the boundaries of the board  ***");
            System.out.println("*** 3- Cards must NOT correspond to already reveled cards ***");
            System.out.println("*************************************************************\n");

            System.out.print("First card - row: ");
            firstCardRow = input.nextInt() - 1; // -1 because the user doesn't take into account the indexing of the array
            System.out.print("First card - column: ");
            firstCardColumn = input.nextInt() - 1;

            System.out.print("Second card - row: ");
            secondCardRow = input.nextInt() - 1;
            System.out.print("Second card - column: ");
            secondCardColumn = input.nextInt() - 1;

            System.out.print('\n');
        } while (!areValuesValid(board, rows, columns, firstCardRow, firstCardColumn, secondCardRow, secondCardColumn));

        // Reveal the two cards the user has selected
        Card firstCard = board[firstCardRow][firstCardColumn];
        firstCard.setShowing(true);

        Card secondCard = board[secondCardRow][secondCardColumn];
        secondCard.setShowing(true);

        //Draw the board here with the two revealed cards
        drawBoard(board);

        // TODO:
        //  1 - If firstCard and secondCard are not equal, then flip them back down after a set timer.
        //  2 - Otherwise if they have the same front, then leave them face up.
        //  In both cases increase the flip count, and save the move to file on a worker thread.
        //  3 - If all cards are flipped up, then end the game and show the top 5-scores loading the file that contains them.
        //  4 - At the beginning of the game the player can choose to:
        //      "start a new game",
        //      "replay most recent game" -> which loads the most recent game saved from file
        //      "change difficulty" -> which changes the timer of the revealed cards
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
     * Adds to each position of the board the given card
     *
     * @param board the game board we want to add cards to
     * @param cards the cards to be displayed inside every tile
     */
    public static void addCardsToBoard(Card[][] board, Card[] cards) {
        int cardNum = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards[cardNum];
                cardNum++;
            }
        }
    }

    /**
     * Draws the board in the console revealing
     * the cards that were selected by the user
     *
     * @param board the board to be drawn into console
     */
    public static void drawBoard(Card[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col].toString() + "\t");
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
            Card[][] board,
            int boardRows,
            int boardColumns,
            int firstCardRow,
            int firstCardColumn,
            int secondCardRow,
            int secondCardColumn
    ) {
        Card firstCard = board[firstCardRow][firstCardColumn];
        Card secondCard = board[secondCardRow][secondCardColumn];

        // 1- first and second card must be different
        if (firstCardRow == secondCardRow && firstCardColumn == secondCardColumn) return false;
        // 2- cards must be inside the boundaries of the board
        if (firstCardRow > boardRows || firstCardColumn > boardColumns) return false;
        // 3- cards must NOT correspond to already reveled cards
        if (firstCard.getIsShowing() || secondCard.getIsShowing()) return false;
        return true;
    }


}
