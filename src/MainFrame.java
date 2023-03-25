package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// fruit icons created by Smashicons - Flaticon: https://www.flaticon.com/free-icons/fruit
// color palette used: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

public class MainFrame extends JFrame implements ActionListener {

    MainButton playButton;
    MainButton replayButton;
    MainButton settingsButton;
    MainButton highScoresButton;

    private static final Color GAME_YELLOW = new Color(255, 203, 0);
    private static final Color GAME_ORANGE = new Color(248, 170, 75);
    private static final Color GAME_RED = new Color(255, 97, 80);
    private static final Color GAME_DEEP_RED = new Color(255, 58, 58);

    MainFrame() {
        // FRAME
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // with this setting, when we hit the X button, the game is going to terminate
        this.setResizable(false); // prevents frame from being resized
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(7, 36, 72));
        this.setLayout(null); // setting the layout manager to null because we're manually placing elements on frame

        ImageIcon gameIcon = new ImageIcon(new ImageIcon("icons/memory_logo.png")
                .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)); // scales the icon
        this.setIconImage(gameIcon.getImage()); // changes the icon of the frame

        // LABEL
        JLabel label = new JLabel();
        label.setText("Memory Game");
        label.setForeground(Color.white); // changes the color of the label
        label.setFont(new Font("Verdana", Font.BOLD, 50)); // changes the font of the label
        label.setBounds(175, 20, 500, 100); // sets the dimension and position of the label

        label.setIcon(gameIcon);
        label.setHorizontalTextPosition(JLabel.LEFT); // sets the position of the label compared to the icon
        label.setVerticalTextPosition(JLabel.TOP); // sets the position of the label compared to the icon
        label.setIconTextGap(20); // sets the gap between the icon and label

        this.add(label);

        //Border border = BorderFactory.createLineBorder(new Color(106, 194, 246)); // creates a border for the label
        //label.setBorder(border);
        //label.setBackground(new Color(11, 101, 178)); // sets the background color of the label
        //label.setOpaque(true); // displays the background color of the label

        //this.pack(); resizes the frame automatically to accommodate all elements inside

        // BUTTONS
        playButton = new MainButton("New Game", GAME_YELLOW, 250, this);
        replayButton = new MainButton("Replay Last Game", GAME_ORANGE, 350, this);
        highScoresButton = new MainButton("High Scores", GAME_RED, 450, this);
        settingsButton = new MainButton("Settings", GAME_DEEP_RED, 550, this);

        this.add(playButton);
        this.add(replayButton);
        this.add(highScoresButton);
        this.add(settingsButton);

        // CALL IT AT THE END OTHERWISE IT WON'T DISPLAY ITEMS!!!
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            openGamePanel();
        } else if (e.getSource() == replayButton) {
            System.out.println("replay button");
        } else if (e.getSource() == highScoresButton) {
            System.out.println("high scores button");
        } else if (e.getSource() == settingsButton) {
            System.out.println("settings button");
        }
    }

    private void openGamePanel() {
        GamePanel gamePanel = new GamePanel(4, 4);
        this.setContentPane(gamePanel);
        // this.setVisible(true); // calling setVisible after content pane has been set to refresh frame
        this.revalidate();
    }

}
