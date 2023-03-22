package src;

public class Board {

    private final int rows;

    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("X");
            }
            System.out.print("\n");
        }
    }

}
