package src;

public class Board<T> {

    private final int rows;

    private final int columns;

    private final Card[] cards;

    public Board(int rows, int columns, Card[] cards) {
        this.rows = rows;
        this.columns = columns;
        this.cards = cards;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Card[] getCards() {
        return cards;
    }

    /**
     * Checks whether the configuration that we get as an input
     * from the user is even, otherwise we can not create the board
     *
     * @return true or false based on whether the configuration is even or not
     */
    public boolean isConfigurationEven() {
        return (rows * columns % 2 == 0);
    }

    /**
     * Draws the board using the number of rows and columns passed
     */
    public void drawBoard() {
        int cardNum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cards[cardNum].faceUp());
                cardNum++;
            }
            System.out.print("\n");
        }
    }

}
