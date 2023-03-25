package src;

import javax.swing.*;
import java.awt.*;

import static src.GameColors.*;
import static src.GameConstants.*;
import static src.GameIcons.*;

// fruit icons created by Smashicons - Flaticon: https://www.flaticon.com/free-icons/fruit
// color palette used: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

public class MainFrame extends JFrame {

    MainFrame() {
        // MAIN FRAME
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // with this setting, when we hit the X button, the game is going to terminate
        this.setResizable(false); // prevents frame from being resized
        this.setSize(800, 800);
        this.getContentPane().setBackground(GAME_BLUE_COLOR);
        this.setLayout(null); // setting the layout manager to null because we're manually placing elements on frame

        ImageIcon gameIcon = new ImageIcon(new ImageIcon(GAME_MEMORY_LOGO)
                .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)); // scales the icon
        this.setIconImage(gameIcon.getImage()); // changes the icon of the frame

        // TITLE LABEL
        TitleLabel titleLabel = new TitleLabel(GAME_TITLE, 175, GAME_MEMORY_LOGO);
        this.add(titleLabel);

        // BUTTONS
        MainButton playButton = new MainButton(GAME_NEW, GAME_YELLOW_COLOR, 250, (e -> openGamePanel()));
        MainButton replayButton = new MainButton(GAME_REPLAY, GAME_ORANGE_COLOR, 350, (e -> openGamePanel()));
        MainButton highScoresButton = new MainButton(GAME_HIGH_SCORES, GAME_RED_COLOR, 450, (e -> openGamePanel()));
        MainButton settingsButton = new MainButton(GAME_SETTINGS, GAME_DEEP_RED_COLOR, 550, (e -> openSettingsPanel()));

        this.add(playButton);
        this.add(replayButton);
        this.add(highScoresButton);
        this.add(settingsButton);

        this.setVisible(true); // CALL IT AT THE END OTHERWISE IT WON'T DISPLAY ITEMS!!!
    }

    private void openGamePanel() {
        GamePanel gamePanel = new GamePanel(4, 4);
        this.setContentPane(gamePanel);
        // this.setVisible(true); // calling setVisible after content pane has been set to refresh frame
        this.revalidate();
    }

    private void openSettingsPanel() {
        SettingsPanel settingsPanel = new SettingsPanel();
        this.setContentPane(settingsPanel);
        this.revalidate();
    }

}
