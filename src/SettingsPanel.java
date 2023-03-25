package src;

import javax.swing.*;
import java.awt.*;

import static src.GameConstants.*;
import static src.GameColors.*;
import static src.GameIcons.*;

public class SettingsPanel extends JPanel {

    SettingsPanel() {
        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        //TITLE LABEL
        TitleLabel titleLabel = new TitleLabel(GAME_SETTINGS, 250, GAME_SETTINGS_LOGO);
        this.add(titleLabel);

        // SLIDER + LABEL
        JLabel timerLabel = new JLabel();
        timerLabel.setText(GAME_TIMER);
        timerLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        timerLabel.setForeground(Color.white);
        timerLabel.setBounds(75, 250, 200, 50);
        this.add(timerLabel);

        JSlider slider = new JSlider(0, 6, 3); // the min and max number of the slider + the starting value
        slider.setBounds(225, 250, 350, 50);
        slider.setPaintTicks(true); // the little signs that show the value
        slider.setMajorTickSpacing(1); // the spacing between the value signs on the slider
        slider.setPaintLabels(true); // the number that shows the value of the signs
        slider.setFont(new Font(GAME_FONT, Font.PLAIN, 15));
        slider.setForeground(Color.white);
        slider.setBackground(GAME_BLUE_COLOR);
        slider.addChangeListener(e -> {}); // the action to trigger when the slider changes
        this.add(slider);

        // TEXTFIELD + LABEL
        JLabel rowColLabel = new JLabel();
        rowColLabel.setText(GAME_CONFIGURATION);
        rowColLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        rowColLabel.setForeground(Color.white);
        rowColLabel.setBounds(15, 400, 200, 50);
        this.add(rowColLabel);

        JTextField textField = new JTextField("4x4");
        textField.setBounds(225, 400, 350, 50);
        textField.setFont(new Font(GAME_FONT, Font.PLAIN, 25));
        this.add(textField);

        this.setVisible(true);
    }

}
