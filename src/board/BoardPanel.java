package src.board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static src.utility.GameConstants.GAME_HIGH_SCORES_FILE;
import static src.utility.GameConstants.GAME_LAST_GAME_FILE;
import static src.utility.GameIcons.gameIcons;

/**
 * The Panel in which the actual game plays out
 */
public class BoardPanel extends JPanel implements ActionListener {

    private Card firstCard;
    private Card secondCard;
    private boolean cardShowing;
    private int flipCount;
    private final Card[] cards;
    private final long timer;
    private final int[] highScores;
    private final String[] scoreLabels;
    private final int rows;
    private final int cols;
    private int highScoreIndex;
    private final ArrayList<String> moves = new ArrayList<>();

    public BoardPanel(int rows, int cols, int timer, int[] highScores, String[] scoreLabels) {
        this.setLayout(new GridLayout(rows, cols));
        this.timer = timer * 250L;
        this.highScores = highScores;
        this.scoreLabels = scoreLabels;
        this.rows = rows;
        this.cols = cols;

        String[] icons = makeIcons(rows, cols);
        cards = createCards(icons);
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
     * Draws the board by adding cards to the container,
     * and adds to each card an action listener.
     *
     * @param cards the array of cards to be displayed
     */
    private void drawBoard(Card[] cards) {
        for (Card card : cards) {
            card.addActionListener(this);
            this.add(card);
        }
    }

    /**
     * Checks whether the new score recorded is
     * a new high score
     *
     * @return true or false based on whether new the score
     * is indeed a new high score or not
     */
    private boolean isNewHighScore() {
        for (int i = 0; i < highScores.length; i++) {
            if (flipCount < highScores[i]) {
                highScoreIndex = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new high score (if present) to the record
     * so that it can later be printed to file
     */
    private void addNewHighScore() {
        int fSTemp;
        int sSTemp = 0;
        String fLTemp;
        String sLTemp = "";
        boolean first = true;

        for (int j = highScoreIndex; j < highScores.length - 1; j++) {
            if (first) {
                fSTemp = highScores[j];
                fLTemp = scoreLabels[j];
                highScores[j] = flipCount;
                scoreLabels[j] = flipCount + " flips on " + rows + "x" + cols + " board";

                sSTemp = highScores[j + 1];
                sLTemp = scoreLabels[j + 1];
                highScores[j + 1] = fSTemp;
                scoreLabels[j + 1] = fLTemp;

                first = false;
            } else {
                int sTemp = highScores[j + 1];
                String lTemp = scoreLabels[j + 1];
                highScores[j + 1] = sSTemp;
                scoreLabels[j + 1] = sLTemp;
                sSTemp = sTemp;
                sLTemp = lTemp;
            }
        }
    }

    /**
     * Writes to file the score achieved in the current game only when
     * better than any of the existing ones.
     */
    private void writeHighScoresToFile() {
        try {
            FileWriter fileWriter = new FileWriter(GAME_HIGH_SCORES_FILE);
            for (String scoreLabel : scoreLabels) {
                if (!Objects.equals(scoreLabel, scoreLabels[scoreLabels.length - 1])) {
                    fileWriter.write(scoreLabel + "\n");
                } else {
                    fileWriter.write(scoreLabel);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the following information about the current game to file:<br>
     * 1. the number of rows and columns<br>
     * 2. the list of cards as displayed onto the board<br>
     * 3. the record of all the moves played by the user.
     */
    private void writeCurrentGameToFile() {
        try {
            FileWriter fileWriter = new FileWriter(GAME_LAST_GAME_FILE);
            fileWriter.write(rows + "\n");
            fileWriter.write(cols + "\n");
            for (Card card : cards) {
                fileWriter.write(card.getName() + "\n");
                fileWriter.write(card.getIcon().toString() + "\n");
            }
            fileWriter.write(flipCount + "\n");
            for (int i = 0; i < moves.size(); i = i + 2) {
                fileWriter.write(moves.get(i) + "\n");
                fileWriter.write(moves.get(i + 1) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!cardShowing) {
            firstCard = (Card) e.getSource();
            // removing the action listener so that we can not
            // click on the same tile twice:
            firstCard.removeActionListener(this);
            System.out.println("First card selected " + firstCard.getName());
            firstCard.showFront();
            cardShowing = true;
        } else {
            secondCard = (Card) e.getSource();
            // removing the action listener so that we can not
            // click on the same tile twice:
            secondCard.removeActionListener(this);
            System.out.println("Second card selected " + secondCard.getName());
            secondCard.showFront();
            // we record the move here because this is where
            // the first and the second card both have value:
            moves.add(firstCard.getName());
            moves.add(firstCard.getIcon().toString());
            moves.add(secondCard.getName());
            moves.add(secondCard.getIcon().toString());
            flipCount++;
            // on a worker thread we wait for some seconds (the timer set by the user),
            // and then we compare the two cards, without blocking the UI:
            new Thread(() -> {
                try {
                    disableCards(cards);
                    if (!Objects.equals(firstCard.getName(), secondCard.getName())) {
                        Thread.sleep(timer);
                        firstCard.showBack();
                        secondCard.showBack();
                    }
                    enableCards(cards);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();
            // if all cards are face up, that means that the game is over
            // and that we should do the following operations:
            // 1. add the new score (if better than any of the top 5 recorded)
            // 2. write the current game to file so that we can replay it if we want
            if (areAllCardsFaceUp(cards)) {
                new Thread(() -> {
                    if (isNewHighScore()) {
                        addNewHighScore();
                        writeHighScoresToFile();
                    }
                    writeCurrentGameToFile();
                }).start();
                JOptionPane.showMessageDialog(null, "Congrats! Your score is " + flipCount);
            }
            cardShowing = false;
        }
    }

    /**
     * Iterates on all available cards to see whether they
     * are all showing (that is, if they all are faceUp).
     * If they are, that means that the game is over.
     *
     * @param cards the cards on the board
     * @return true or false based on whether the cards
     * are all face up or not.
     */
    private boolean areAllCardsFaceUp(Card[] cards) {
        for (Card card : cards) {
            if (!card.getIsShowing()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Disables all the cards.
     *
     * @param cards the array of cards to disable
     */
    private void disableCards(Card[] cards) {
        for (Card card : cards) {
            card.removeActionListener(this);
        }
    }

    /**
     * Enables all the cards except those that are already showing.
     * In that case a match has been found.
     *
     * @param cards the array of cards to enable
     */
    private void enableCards(Card[] cards) {
        for (Card card : cards) {
            if (!card.getIsShowing()) {
                card.addActionListener(this);
            }
        }
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public int[] getHighScores() {
        return highScores;
    }

    public String[] getScoreLabels() {
        return scoreLabels;
    }

    public long getTimer() {
        return timer;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
