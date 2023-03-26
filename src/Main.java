package src;

import src.Card;
import src.main.MainFrame;

public class Main {

    public static void main(String[] args) {
        new MainFrame();
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
