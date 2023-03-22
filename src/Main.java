package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card("!", "X");
        Card card2 = new Card("%", "X");

        configureBoard();
    }

    public static void configureBoard() {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = input.nextInt();

        System.out.print("Number of columns: ");
        int columns = input.nextInt();

        if (isConfigurationEven(rows, columns)) {
            // draw the board
            drawBoard(rows, columns);
        }
    }

    /**
     * Checks whether the configuration that we get as an input
     * from the user is even, otherwise we can not create the board
     * @return true or false based on whether the configuration is even or not
     */
    public static boolean isConfigurationEven(int rows, int columns) {
        return (rows*columns % 2 == 0);
    }

    /**
     * Draws the board based on the inputs passed
     * @param rows the number of rows to be displayed
     * @param columns the number of columns to be displayed
     */
    public static void drawBoard(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("X");
            }
            System.out.print("\n");
        }
    }

}
