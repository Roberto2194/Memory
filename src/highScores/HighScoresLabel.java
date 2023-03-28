package src.highScores;

import javax.swing.*;
import java.awt.*;

import static src.utility.GameConstants.GAME_FONT;

public class HighScoresLabel extends JLabel {

    HighScoresLabel(char pos, int yCoord, int rows, int cols, int flips) {
        this.setText(pos + ". " + flips + " flips on " + rows + "x" + cols + " board");
        this.setBounds(250, yCoord, 400, 50);
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        this.setForeground(Color.white);
        this.setVisible(true);
    }

}
