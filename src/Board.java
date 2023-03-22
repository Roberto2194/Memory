package src;

public class Board {

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
     * Draws the board using the number of rows and columns stored
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
