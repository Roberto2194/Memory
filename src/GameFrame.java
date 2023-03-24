package src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameFrame extends JFrame {

    // https://www.flaticon.com/free-icons/fruit" Fruit icons created by Smashicons - Flaticon
    // cool palette: https://colors.muz.li/palette/072448/54d2d2/ffcb00/f8aa4b/ff6150

    GameFrame() {
        // FRAME
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // with this setting, when we hit the X button, the game is going to terminate
        this.setResizable(false); // prevents frame from being resized
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(7, 36, 72)); // changes the color of the background
        this.setVisible(true);
        this.setLayout(null); // setting the layout manager to null because it does weird things

        ImageIcon gameIcon = new ImageIcon("icons/memory_logo.png");
        this.setIconImage(gameIcon.getImage()); // this changes the icon of the frame

        // LABEL
        JLabel label = new JLabel();
        label.setText("Memory Game");
        this.add(label);

        //Border border = BorderFactory.createLineBorder(new Color(106, 194, 246)); // creates a border for the label
        //label.setBorder(border);

        label.setVerticalAlignment(JLabel.TOP); // set vertical position of the label
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of the label
        label.setForeground(Color.white); // changes the color of the label
        label.setFont(new Font("Verdana", Font.PLAIN, 50)); // changes the font of the label
        label.setBounds(200, 20, 400, 100); // sets the dimension and position of the label

        //label.setBackground(new Color(11, 101, 178)); // sets the background color of the label
        //label.setOpaque(true); // displays the background color of the label

        //this.pack(); resizes the frame automatically to accommodate all elements inside
    }

}
