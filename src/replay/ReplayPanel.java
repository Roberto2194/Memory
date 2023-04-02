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

    int rows;
    int cols;
    ArrayList<String> cardLabels = new ArrayList<>();
    ArrayList<String> cardLabelsIdentifiers = new ArrayList<>();
    int flipCount;
    ArrayList<String> moves = new ArrayList<>();
    ArrayList<String> movesIdentifiers = new ArrayList<>();
    Card[] cards;

    public ReplayPanel() {
        loadLastGameFromFile();
        this.setLayout(new GridLayout(rows, cols));

        cards = createCards(cardLabels);
        drawBoard(cards);

        // TODO: - PLAY OUT THE MOVES ONE BY ONE
        //  Si potrebbe la stessa logica utilizzata in BoardPanel:
        //  flippa la prima carta della lista e a seguire dopo poco la seconda.
        //  Se sono uguali allora lasciale faccia su, altrimenti girale faccia giù.
        //  Continua il processo fin quando tutte le carte sono scoperte faccia su.

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

    private void playOutGame() {
        new Thread(() -> {
            try {
                for (int i = 0; i < moves.size(); i++) {
                    for (int j = 0; j < cardLabelsIdentifiers.size(); j++) {
                        if (Objects.equals(movesIdentifiers.get(i), cardLabelsIdentifiers.get(j))) {
                            Thread.sleep(1000L);
                            cards[j].showFront();
                            break;
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


}
