package src.settings;

import src.TitleLabel;

import javax.swing.*;

import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

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
        SettingsSlider settingsSlider = new SettingsSlider(3, 225, 225);
        settingsSlider.addChangeListener(e -> this.timer = settingsSlider.getValue());
        this.add(timerLabel);
        this.add(settingsSlider);

        SettingsLabel rowsLabel = new SettingsLabel(GAME_ROWS, 115, 325);
        SettingsTextField rowsTextField = new SettingsTextField("4", 225, 325);
        rowsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> this.rows = checkIntegerValue(rowsTextField.getText()));
        this.add(rowsLabel);
        this.add(rowsTextField);

        SettingsLabel colsLabel = new SettingsLabel(GAME_COLUMNS, 75, 425);
        SettingsTextField colsTextField = new SettingsTextField("4", 225, 425);
        colsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> this.cols = checkIntegerValue(colsTextField.getText()));
        this.add(colsLabel);
        this.add(colsTextField);

        // DISCLAIMER LABEL

        this.setVisible(true);
    }

    /**
     * Checks to see whether the user inserted a valid integer value
     * inside the rows or columns textField.<br>
     * If he or she hasn't, then it returns 4, the default starting value.
     *
     * @param value the value we want to check
     * @return the value inserted by the user, if correct, or 4, the default value
     */
    private int checkIntegerValue(String value) {
        int parsedInt = 4;
        try {
            parsedInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please insert a number", "Invalid input", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid input: " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Found an unknown exception", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Unexpected error" + e);
        }
        return parsedInt;
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
