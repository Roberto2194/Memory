package src.main;

import src.board.BoardPanel;
import src.highScores.HighScoresPanel;
import src.home.HomePanel;
import src.settings.SettingsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private MainButton settingsButton;
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

        this.setVisible(true);
    }

    private void openBoardPanel() {
        BoardPanel boardPanel = new BoardPanel(rows, cols, timer);

        this.setContentPane(boardPanel);
        this.revalidate();
    }

    private void openHighScoresPanel() {
        HighScoresPanel highScoresPanel = new HighScoresPanel();

        MainButton highScoresBackButton = new MainButton(GAME_BACK_BUTTON, GAME_RED_COLOR, 600, this);
        highScoresPanel.add(highScoresBackButton);

        this.setContentPane(highScoresPanel);
        this.revalidate();
    }

    private void openSettingsPanel() {
        settingsPanel = new SettingsPanel();

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
        settingsButton = new MainButton(GAME_SETTINGS, GAME_DEEP_RED_COLOR, 550, (e -> openSettingsPanel()));

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
            settingsButton.setEnabled(false);
        }
    }

}
