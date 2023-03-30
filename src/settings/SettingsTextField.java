package src.settings;

import javax.swing.*;
import java.awt.*;
import static src.utility.GameConstants.*;

public class SettingsTextField extends JTextField {

    public SettingsTextField(String text, int xCoord, int yCoord) {
        this.setText(text);
        this.setBounds(xCoord, yCoord, 350, 50);
        this.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
    }

}
