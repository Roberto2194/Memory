package src;

import javax.swing.*;
import java.awt.*;
import static src.GameConstants.*;

public class TitleLabel extends JLabel {

    TitleLabel(String title, int xCoord, String icon) {
        this.setText(title);
        this.setForeground(Color.white); // changes the color of the label
        this.setFont(new Font(GAME_FONT, Font.BOLD, 50)); // changes the font of the label
        this.setBounds(xCoord, 20, 500, 100); // sets the dimension and position of the label
        this.setIcon(new ImageIcon(new ImageIcon(icon).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        this.setHorizontalTextPosition(JLabel.LEFT); // sets the position of the label compared to the icon
        this.setVerticalTextPosition(JLabel.TOP); // sets the position of the label compared to the icon
        this.setIconTextGap(20); // sets the gap between the icon and label
    }

}
