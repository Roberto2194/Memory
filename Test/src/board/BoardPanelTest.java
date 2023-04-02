package src.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;
import static src.utility.GameIcons.GAME_PUMPKIN;
import static src.utility.GameIcons.GAME_WATERMELON;

class BoardPanelTest {

    BoardPanel boardPanel;
    int rows = 4;
    int cols = 4;
    int timer = 5;
    int[] highScores = {12, 14, 16, 18, 20};
    String[] scoreLabels = {
            "12 flips on 4x4 board",
            "14 flips on 4x4 board",
            "16 flips on 6x6 board",
            "18 flips on 6x6 board",
            "20 flips on 4x4 board"
    };

    @BeforeEach
    void setUp() {
        boardPanel = new BoardPanel(rows, cols, timer, highScores, scoreLabels);
    }

    @Test
    void actionPerformed() {
        Card cardPumpkin = new Card(GAME_PUMPKIN);
        ActionEvent actionEventPumpkin = new ActionEvent(cardPumpkin, 1, "");
        boardPanel.actionPerformed(actionEventPumpkin);
        assertEquals(cardPumpkin, boardPanel.getFirstCard());

        Card cardWatermelon = new Card(GAME_WATERMELON);
        ActionEvent actionEventWatermelon = new ActionEvent(cardWatermelon, 2, "");
        boardPanel.actionPerformed(actionEventWatermelon);
        assertEquals(cardWatermelon, boardPanel.getSecondCard());
    }

    @Test
    void getTimer() {
        long boardTimer = boardPanel.getTimer();
        long localTimer = timer * 250L; // we multiply by 250L in the constructor of the Panel
        assertEquals(boardTimer, localTimer);
    }

    @Test
    void getRows() {
        int boardRows = boardPanel.getRows();
        assertEquals(boardRows, rows);
    }

    @Test
    void getCols() {
        int boardCols = boardPanel.getCols();
        assertEquals(boardCols, cols);
    }

    @Test
    void getHighScores() {
        int[] boardHighScores = boardPanel.getHighScores();
        assertEquals(boardHighScores, highScores);
    }

    @Test
    void getScoreLabels() {
        String[] boardScoreLabels = boardPanel.getScoreLabels();
        assertEquals(boardScoreLabels, scoreLabels);
    }

}