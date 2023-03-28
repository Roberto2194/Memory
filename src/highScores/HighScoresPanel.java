package src.highScores;

import src.main.TitleLabel;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;

import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

public class HighScoresPanel extends JPanel {

    public HighScoresPanel() {
        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        ArrayList<Character> scores = readFromFile();
        //this contains at each position a different score string:
        String[] scoreLabels = buildLabels(scores);

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

    /**
     * Reads the contents of the given file as a stream
     * of characters (this is a property of FileReader),
     * and adds each character to an array list
     *
     * @return the array list containing all the individual
     * characters read from file
     */
    private ArrayList<Character> readFromFile() {
        ArrayList<Character> scoresList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(GAME_HIGH_SCORES_FILE);
            int data = fileReader.read();
            scoresList.add((char) data);

            // when read() returns -1, the is no more data to be read.
            while (data != -1) {
                data = fileReader.read();
                scoresList.add((char) data);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return scoresList;
    }

    /**
     * Builds each of the high scores by going through the
     * array of characters and putting each individual
     * score in a different position of the scoresArray
     *
     * @param scores the list that contains the characters read from file
     * @return the scoresArray that contains all the individual high scores strings
     */
    private String[] buildLabels(ArrayList<Character> scores) {
        String[] scoresArray = new String[5];
        StringBuilder scoreString = new StringBuilder();

        int arrayIndex = 0;
        for (Character score : scores) {
            // the \n char appears at every eol of string
            // the uFFFF char appears at the very last string
            if (score != '\n' && score != '\uFFFF') {
                scoreString.append(score);
            } else if (!scoreString.isEmpty()) {
                scoresArray[arrayIndex] = String.valueOf(scoreString);
                // we reset the string if we've reached the \n char
                // so that we can build a new one
                scoreString = new StringBuilder();
                arrayIndex++;
            }
        }

        // fills the empty positions of the array (if any)
        if (arrayIndex <= 4) {
            for (int i = arrayIndex; i <= 4; i++) {
                scoresArray[i] = GAME_NO_SCORE_RECORDED_YET;
            }
        }

        return scoresArray;
    }

}
