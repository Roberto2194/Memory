package src.highScores;

import src.main.TitleLabel;
import javax.swing.*;
import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

public class HighScoresPanel extends JPanel {

    public HighScoresPanel(String[] scoreLabels) {
        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        TitleLabel titleLabel = new TitleLabel(GAME_HIGH_SCORES, 190, GAME_HIGH_SCORES_LOGO);
        this.add(titleLabel);

        HighScoresLabel highScoreOne = new HighScoresLabel('1', scoreLabels[0], 200);
        HighScoresLabel highScoreTwo = new HighScoresLabel('2', scoreLabels[1], 265);
        HighScoresLabel highScoreThree = new HighScoresLabel('3', scoreLabels[2], 330);
        HighScoresLabel highScoreFour = new HighScoresLabel('4', scoreLabels[3], 395);
        HighScoresLabel highScoreFive = new HighScoresLabel('5', scoreLabels[4], 460);

        this.add(highScoreOne);
        this.add(highScoreTwo);
        this.add(highScoreThree);
        this.add(highScoreFour);
        this.add(highScoreFive);

        this.setVisible(true);
    }

}
