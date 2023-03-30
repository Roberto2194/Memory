package src.highScores;

import javax.swing.*;
import java.awt.*;
import static src.utility.GameConstants.GAME_FONT;

public class HighScoresLabel extends JLabel {

    HighScoresLabel(char pos, String text, int yCoord) {
        this.setText(pos + ". " + text);
        this.setBounds(250, yCoord, 400, 50);
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        this.setForeground(Color.white);
        this.setVisible(true);
    }

}
