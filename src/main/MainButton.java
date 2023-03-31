package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import static src.utility.GameConstants.*;

public class MainButton extends JButton {

    MainButton(String title, Color color, int verticalPos, ActionListener actionListener) {
        this.setText(title);
        this.setFocusable(false);
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        this.setBackground(color);
        this.setBounds(200, verticalPos, 400, 50);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addActionListener(actionListener);
    }

}
