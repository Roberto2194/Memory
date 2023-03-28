package src.highScores;

import src.TitleLabel;

import javax.swing.*;

import java.io.*;

import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

public class HighScoresPanel extends JPanel {

    public HighScoresPanel(int rows, int cols, int flips) {
        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        TitleLabel titleLabel = new TitleLabel(GAME_HIGH_SCORES, 190, GAME_HIGH_SCORES_LOGO);
        this.add(titleLabel);

        HighScoresLabel highScoreOne = new HighScoresLabel('1', 200, rows, cols, flips);
        this.add(highScoreOne);

        HighScoresLabel highScoreTwo = new HighScoresLabel('2', 265, rows, cols, flips);
        this.add(highScoreTwo);

        HighScoresLabel highScoreThree = new HighScoresLabel('3', 330, rows, cols, flips);
        this.add(highScoreThree);

        HighScoresLabel highScoreFour = new HighScoresLabel('4', 395, rows, cols, flips);
        this.add(highScoreFour);

        HighScoresLabel highScoreFive = new HighScoresLabel('5', 460, rows, cols, flips);
        this.add(highScoreFive);

        writeToFile();
        readFromFile();
    }

    private void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("high_scores.txt");
            fileWriter.write("12 flips on 4x4 board");
            fileWriter.append("\n15 flips on 4x4 board");
            fileWriter.append("\n22 flips on 6x6 board");
            fileWriter.append("\n28 flips on 6x6 board");
            fileWriter.append("\n32 flips on 4x4 board");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // FileReader reads the contents of a file as a stream of characters.
    // One by one read() returns an int value which contains the byte value
    // when read() returns -1, the is no more data to be read.
    private void readFromFile() {
        try {
            FileReader fileReader = new FileReader("high_scores.txt");
            int data = fileReader.read();

            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
