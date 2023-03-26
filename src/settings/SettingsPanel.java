package src.settings;

import src.TitleLabel;

import javax.swing.*;

import static src.GameColors.GAME_BLUE_COLOR;
import static src.GameConstants.*;
import static src.GameIcons.GAME_SETTINGS_LOGO;

public class SettingsPanel extends JPanel {

    private int timer = 3;
    private int rows = 4;
    private int cols = 4;

    public SettingsPanel() {
        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        TitleLabel titleLabel = new TitleLabel(GAME_SETTINGS, 250, GAME_SETTINGS_LOGO);
        this.add(titleLabel);

        SettingsLabel timerLabel = new SettingsLabel(GAME_TIMER, 75, 225);
        SettingsSlider settingsSlider = new SettingsSlider(225, 225);
        settingsSlider.addChangeListener(e -> this.timer = settingsSlider.getValue());
        this.add(timerLabel);
        this.add(settingsSlider);

        SettingsLabel rowsLabel = new SettingsLabel(GAME_ROWS, 115, 325);
        SettingsTextField rowsTextField = new SettingsTextField("4", 225, 325);
        rowsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> rows = Integer.parseInt(rowsTextField.getText()));
        this.add(rowsLabel);
        this.add(rowsTextField);

        SettingsLabel colsLabel = new SettingsLabel(GAME_COLUMNS, 75, 425);
        SettingsTextField colsTextField = new SettingsTextField("4", 225, 425);
        colsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> cols = Integer.parseInt(colsTextField.getText()));
        this.add(colsLabel);
        this.add(colsTextField);

        // DISCLAIMER LABEL

        this.setVisible(true);
    }

    public int getTimer() {
        return timer;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
