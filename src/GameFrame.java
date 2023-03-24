package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    // https://www.flaticon.com/free-icons/fruit" Fruit icons created by Smashicons - Flaticon
    // cool palette: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

    JButton playButton;
    JButton replayButton;
    JButton settingsButton;

    private static final Color GAME_YELLOW = new Color(255, 203, 0);
    private static final Color GAME_ORANGE = new Color(248, 170, 75);
    private static final Color GAME_RED = new Color(255, 97, 80);

    GameFrame() {
        // FRAME
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // with this setting, when we hit the X button, the game is going to terminate
        this.setResizable(false); // prevents frame from being resized
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(7, 36, 72)); // changes the color of the background
        this.setLayout(null); // setting the layout manager to null because it does weird things

        ImageIcon gameIcon = new ImageIcon(new ImageIcon("icons/memory_logo.png")
                .getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        this.setIconImage(gameIcon.getImage()); // this changes the icon of the frame

        // LABEL
        JLabel label = new JLabel();
        label.setText("Memory Game");
        label.setIcon(gameIcon);
        label.setHorizontalTextPosition(JLabel.LEFT); //sets the position of the label compared to the icon
        label.setVerticalTextPosition(JLabel.TOP); //sets the position of the label compared to the icon
        label.setIconTextGap(20); // sets the gap between the icon and label

        label.setForeground(Color.white); // changes the color of the label
        label.setFont(new Font("Verdana", Font.BOLD, 50)); // changes the font of the label
        label.setBounds(175, 20, 500, 100); // sets the dimension and position of the label

        this.add(label);

        //Border border = BorderFactory.createLineBorder(new Color(106, 194, 246)); // creates a border for the label
        //label.setBorder(border);
        //label.setBackground(new Color(11, 101, 178)); // sets the background color of the label
        //label.setOpaque(true); // displays the background color of the label

        //this.pack(); resizes the frame automatically to accommodate all elements inside

        // BUTTONS
        playButton = new GameButton("New Game", GAME_YELLOW, 250, this);
        this.add(playButton);

        replayButton = new GameButton("Replay Game", GAME_ORANGE, 350, this);
        this.add(replayButton);

        settingsButton = new GameButton("Settings", GAME_RED, 450, this);
        this.add(settingsButton);

        // CALL IT AT THE END OTHERWISE IT WON'T DISPLAY ITEMS!!!
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            // action to perform when we click on button
            System.out.println("play button");
        } else if (e.getSource() == replayButton) {
            // action to perform when we click on button
            System.out.println("replay button");
        } else if (e.getSource() == settingsButton) {
            // action to perform when we click on button
            System.out.println("settings button");
        }
    }

}
