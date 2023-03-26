package src.settings;

import javax.swing.*;
import java.awt.*;

import static src.GameConstants.*;

public class SettingsLabel extends JLabel {

    public SettingsLabel(String text, int xCoord, int yCoord) {
        this.setText(text);
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        this.setForeground(Color.white);
        this.setBounds(xCoord, yCoord, 200, 50);
        this.setVisible(true);
    }

}
