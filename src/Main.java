package src;

public class Main {

    public static void main(String[] args) {
        new MainFrame();

        // TODO: 0 - load random icons when starting a new game. Make sure that there are 2 pairs of each icon,
        //  and that the user is able to score points if 2 cards are reveled with the same icon.
        //  1 - If firstCard and secondCard are not equal, then flip them back down after a set timer.
        //  2 - Otherwise if they have the same front, then leave them face up.
        //  In both cases increase the flip count (and save the move to file on a worker thread)
        //  3 - If all cards are flipped up, then end the game and load the files with the top 5-scores.
        //  if the current game has a higher score than any of the top 5 ones, save it to file and display it.
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
