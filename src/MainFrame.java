package src;

import src.settings.SettingsPanel;

import javax.swing.*;
import java.awt.*;

import static src.GameColors.*;
import static src.GameConstants.*;
import static src.GameIcons.*;

// fruit icons created by Smashicons - Flaticon: https://www.flaticon.com/free-icons/fruit
// color palette used: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

public class MainFrame extends JFrame {

    private int timer;
    private int rows;
    private int cols;

    MainFrame() {
        // MAIN FRAME
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

    private void openSettingsPanel() {
        SettingsPanel settingsPanel = new SettingsPanel();

        MainButton settingsSubmitButton = new MainButton(GAME_SUBMIT_BUTTON, GAME_DEEP_RED_COLOR, 600, (e -> {
            openHomePanel();
            timer = settingsPanel.getTimer();
            rows = settingsPanel.getRows();
            cols = settingsPanel.getCols();
        }));
        settingsPanel.add(settingsSubmitButton);

        this.setContentPane(settingsPanel);
        this.revalidate();
    }

    private void openHomePanel() {
        HomePanel homePanel = new HomePanel();

        MainButton playButton = new MainButton(GAME_NEW, GAME_YELLOW_COLOR, 250, (e -> openBoardPanel()));
        MainButton replayButton = new MainButton(GAME_REPLAY, GAME_ORANGE_COLOR, 350, (e -> openBoardPanel()));
        MainButton highScoresButton = new MainButton(GAME_HIGH_SCORES, GAME_RED_COLOR, 450, (e -> openBoardPanel()));
        MainButton settingsButton = new MainButton(GAME_SETTINGS, GAME_DEEP_RED_COLOR, 550, (e -> openSettingsPanel()));

        homePanel.add(playButton);
        homePanel.add(replayButton);
        homePanel.add(highScoresButton);
        homePanel.add(settingsButton);

        this.setContentPane(homePanel);
        this.revalidate();
    }

}
