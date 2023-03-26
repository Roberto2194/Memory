package src.settings;

import javax.swing.*;
import java.awt.*;

import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;

public class SettingsSlider extends JSlider {

    public SettingsSlider(int value, int xCoord, int yCoord) {
        this.setMinimum(0);
        this.setMaximum(6);
        this.setValue(value);
        this.setBounds(xCoord, yCoord, 350, 50);
        this.setPaintTicks(true); // the little signs that show the value
        this.setMajorTickSpacing(1); // the spacing between the value signs on the slider
        this.setPaintLabels(true); // the number that shows the value of the signs
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 15));
        this.setForeground(Color.white);
        this.setBackground(GAME_BLUE_COLOR);
        this.setVisible(true);
    }

}
