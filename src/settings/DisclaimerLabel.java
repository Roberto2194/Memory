package src.settings;

import javax.swing.*;
import java.awt.*;

public class DisclaimerLabel extends JLabel {

    DisclaimerLabel(String text, int xCoord, int yCoord) {
        this.setText(text);
        this.setBounds(xCoord, yCoord, 400, 100);
        this.setForeground(Color.white);
        this.setVisible(true);
    }

}
