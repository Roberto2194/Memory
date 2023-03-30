package src.main;

import src.board.BoardPanel;
import src.highScores.HighScoresPanel;
import src.home.HomePanel;
import src.settings.SettingsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

// fruit icons created by Smashicons - Flaticon: https://www.flaticon.com/free-icons/fruit
// color palette used: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

/**
 * The container class of the whole application,
 * used to manage navigation between the Panels.
 */
public class MainFrame extends JFrame implements ActionListener {

    private SettingsPanel settingsPanel;
    private MainButton settingsSubmitButton;
    int[] highScores;
    int arrayIndex;
    String[] scoreLabels;
    private int timer = 3;
    private int rows = 4;
    private int cols = 4;

    public MainFrame() {
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // with this setting, when we hit the X button, the game is going to terminate
        this.setResizable(false); // prevents frame from being resized
        this.setSize(800, 800);

        ImageIcon gameIcon = new ImageIcon(new ImageIcon(GAME_MEMORY_LOGO)
                .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)); // scales the icon
        this.setIconImage(gameIcon.getImage()); // changes the icon of the frame

        openHomePanel();

        ArrayList<Character> scores = readFromFile();
        //this contains at each position a different score string:
        scoreLabels = buildLabels(scores);
        highScores = buildHighScores(scoreLabels, arrayIndex);
        fillEmptyPositions(scoreLabels, arrayIndex);

        this.setVisible(true);
    }

    private void openBoardPanel() {
        BoardPanel boardPanel = new BoardPanel(rows, cols, timer, highScores, scoreLabels);

        this.setContentPane(boardPanel);
        this.revalidate();
    }

    private void openHighScoresPanel() {
        HighScoresPanel highScoresPanel = new HighScoresPanel(scoreLabels);

        MainButton highScoresBackButton = new MainButton(GAME_BACK_BUTTON, GAME_RED_COLOR, 600, this);
        highScoresBackButton.setFocusable(false);
        highScoresPanel.add(highScoresBackButton);

        this.setContentPane(highScoresPanel);
        this.revalidate();
    }

    private void openSettingsPanel() {
        settingsPanel = new SettingsPanel(timer, rows, cols);

        settingsSubmitButton = new MainButton(GAME_SUBMIT_BUTTON, GAME_DEEP_RED_COLOR, 600, this);
        settingsPanel.add(settingsSubmitButton);

        this.setContentPane(settingsPanel);
        this.revalidate();
    }

    private void openHomePanel() {
        HomePanel homePanel = new HomePanel();

        MainButton playButton = new MainButton(GAME_NEW, GAME_YELLOW_COLOR, 250, (e -> openBoardPanel()));
        MainButton replayButton = new MainButton(GAME_REPLAY, GAME_ORANGE_COLOR, 350, (e -> openBoardPanel()));
        MainButton highScoresButton = new MainButton(GAME_HIGH_SCORES, GAME_RED_COLOR, 450, (e -> openHighScoresPanel()));
        MainButton settingsButton = new MainButton(GAME_SETTINGS, GAME_DEEP_RED_COLOR, 550, (e -> openSettingsPanel()));

        homePanel.add(playButton);
        homePanel.add(replayButton);
        homePanel.add(highScoresButton);
        homePanel.add(settingsButton);

        this.setContentPane(homePanel);
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openHomePanel();
        if (e.getSource() == settingsSubmitButton) {
            timer = settingsPanel.getTimer();
            rows = settingsPanel.getRows();
            cols = settingsPanel.getCols();
        }
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

        this.arrayIndex = arrayIndex;

        return scoresArray;
    }

    /**
     * Fills the empty positions of the array with a set string
     *
     * @param scoresArray the array we want to fill the positions with
     * @param arrayIndex  the index at which we should fill the empty positions
     */
    private void fillEmptyPositions(String[] scoresArray, int arrayIndex) {
        // fills the empty positions of the array (if any)
        if (arrayIndex <= 4) {
            for (int i = arrayIndex; i <= 4; i++) {
                scoresArray[i] = GAME_NO_SCORE_RECORDED_YET;
            }
        }
    }

    /**
     * Builds an array of integers containing the high
     * scores red from file
     *
     * @return the array of integers containing the high scores
     */
    private int[] buildHighScores(String[] scoreLabels, int arrayIndex) {
        int[] highScores = new int[arrayIndex];
        StringBuilder scoreString = new StringBuilder();

        int highScoresIndex = 0;
        for (String score : scoreLabels) {
            if (score == null) break;
            for (int i = 0; i < score.length(); i++) {
                if (score.charAt(i) == ' ') {
                    highScores[highScoresIndex] = Integer.parseInt(String.valueOf(scoreString));
                    scoreString = new StringBuilder();
                    highScoresIndex++;
                    break;
                }
                scoreString.append(score.charAt(i));
            }
        }

        return highScores;
    }

}
