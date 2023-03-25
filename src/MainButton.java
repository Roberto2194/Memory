package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainButton extends JButton {

    private static final String FONT_NAME = "Verdana";

    MainButton(String title, Color color, int verticalPos, ActionListener actionListener) {
        this.setText(title);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        this.setBackground(color);
        this.setBounds(200, verticalPos, 400, 50);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addActionListener(actionListener);
    }

}
