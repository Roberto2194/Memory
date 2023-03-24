package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameButton extends JButton {

    private static final String FONT_NAME = "Verdana";

    GameButton(String title, Color color, int height, ActionListener actionEvent) {
        this.setText(title);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        this.setBackground(color);
        this.setBounds(200, height, 400, 50);
        this.addActionListener(actionEvent);
    }

}
