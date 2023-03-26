package src;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static src.utility.GameIcons.*;

public class BoardPanel extends JPanel {

    BoardPanel(int rows, int cols, int timer) {
        System.out.println("Board panel timer: " + timer);
        System.out.println("Board panel rows: " + rows);
        System.out.println("Board panel cols: " + cols);

        this.setLayout(new GridLayout(rows, cols));

        String[] icons = makeIcons(rows, cols);
        Card[] cards = createCards(icons);
        shuffleCards(cards);
        drawBoard(cards);

        this.setVisible(true);
    }

    /**
     * Creates as many icons as tiles inside the board.
     * The number of tiles is given by rows*columns.
     *
     * @param rows the number of rows
     * @param cols the number of columns
     * @return the array of icons created
     */
    private String[] makeIcons(int rows, int cols) {
        String[] icons = new String[rows * cols];
        // we add two of the same symbol to the array
        // this is going to help us when we create the cards
        int iconsCounter = 0;
        for (int i = 0; i < icons.length; i = i + 2) {
            icons[i] = gameIcons[iconsCounter];
            icons[i + 1] = gameIcons[iconsCounter];
            iconsCounter++;
        }

        return icons;
    }

    /**
     * Creates as many cards as the number of icons given
     *
     * @param icons the array of icons
     * @return the array of cards created
     */
    private Card[] createCards(String[] icons) {
        Card[] cards = new Card[icons.length];

        int i = 0;
        while (i < icons.length) {
            cards[i] = new Card(icons[i]);
            i++;
        }

        return cards;
    }

    /**
     * Shuffles an array of cards putting them in a
     * random order, so that the positioning of the cards
     * onto the board is less predictable.
     *
     * @param cards the cards that need to be shuffled
     */
    private void shuffleCards(Card[] cards) {
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
     * Draws the board by adding cards to the container
     *
     * @param cards the array of cards to be displayed
     */
    private void drawBoard(Card[] cards) {
        for (Card card : cards) {
            this.add(card);
        }
    }

}
