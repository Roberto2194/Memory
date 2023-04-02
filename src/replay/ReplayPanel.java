package src.replay;

import src.board.Card;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static src.utility.GameConstants.*;

public class ReplayPanel extends JPanel {

    private int rows;
    private int cols;
    private final ArrayList<String> cardLabels = new ArrayList<>();
    private final ArrayList<String> cardLabelsIdentifiers = new ArrayList<>();
    private int flipCount;
    private final ArrayList<String> moves = new ArrayList<>();
    private final ArrayList<String> movesIdentifiers = new ArrayList<>();
    private final Card[] cards;
    private boolean cardShowing;
    private Card firstCard;
    private Card secondCard;

    public ReplayPanel() {
        loadLastGameFromFile();
        this.setLayout(new GridLayout(rows, cols));

        cards = createCards(cardLabels);
        drawBoard(cards);

        playOutGame();
    }

    /**
     * Loads last game from file and puts the
     * data respectively into local properties
     */
    private void loadLastGameFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GAME_LAST_GAME_FILE));
            rows = Integer.parseInt(bufferedReader.readLine());
            cols = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < (rows * cols) * 2; i = i + 2) {
                cardLabels.add(bufferedReader.readLine());
                cardLabelsIdentifiers.add(bufferedReader.readLine());
            }

            flipCount = Integer.parseInt(bufferedReader.readLine());

            for (int j = 0; j < flipCount * 4; j = j + 2) {
                moves.add(bufferedReader.readLine());
                movesIdentifiers.add(bufferedReader.readLine());
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Replays the most recent game by looping through
     * the list of moves and its identifiers
     */
    private void playOutGame() {
        new Thread(() -> {
            try {
                for (int i = 0; i < moves.size(); i++) {
                    for (int j = 0; j < cardLabelsIdentifiers.size(); j++) {
                        if (Objects.equals(movesIdentifiers.get(i), cardLabelsIdentifiers.get(j))) {
                            Thread.sleep(1000L);
                            if (!cardShowing) {
                                firstCard = cards[j];
                                firstCard.showFront();
                                cardShowing = true;
                            } else {
                                secondCard = cards[j];
                                secondCard.showFront();
                                // if the two cards are different then they should go back face down:
                                if (!Objects.equals(firstCard.getName(), secondCard.getName())) {
                                    Thread.sleep(1000L);
                                    firstCard.showBack();
                                    secondCard.showBack();
                                }
                                if (areAllCardsFaceUp(cards)) {
                                    JOptionPane.showMessageDialog(null, "Congrats! Your score is " + flipCount);
                                }
                                cardShowing = false;
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * Creates as many cards as the number of cardLabels given
     *
     * @param cardLabels the array of cardLabels
     * @return the array of cards created
     */
    private Card[] createCards(ArrayList<String> cardLabels) {
        Card[] cards = new Card[cardLabels.size()];

        int i = 0;
        while (i < cardLabels.size()) {
            cards[i] = new Card(cardLabels.get(i));
            i++;
        }

        return cards;
    }

    /**
     * Draws the board by adding cards to the container,
     *
     * @param cards the array of cards to be displayed
     */
    private void drawBoard(Card[] cards) {
        for (Card card : cards) {
            this.add(card);
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

    public ArrayList<String> getCardLabels() {
        return cardLabels;
    }

    public ArrayList<String> getCardLabelsIdentifiers() {
        return cardLabelsIdentifiers;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public ArrayList<String> getMovesIdentifiers() {
        return movesIdentifiers;
    }

}
