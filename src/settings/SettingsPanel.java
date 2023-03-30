package src.settings;

import src.main.TitleLabel;
import javax.swing.*;
import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

/**
 * The Panel for managing both the timer
 * and the configuration of the board.
 */
public class SettingsPanel extends JPanel {

    private int timer;
    private int rows;
    private int cols;

    public SettingsPanel(int timer, int rows, int cols) {
        this.timer = timer;
        this.rows = rows;
        this.cols = cols;

        this.setBackground(GAME_BLUE_COLOR);
        this.setLayout(null);

        TitleLabel titleLabel = new TitleLabel(GAME_SETTINGS, 250, GAME_SETTINGS_LOGO);
        this.add(titleLabel);

        SettingsLabel timerLabel = new SettingsLabel(GAME_TIMER, 75, 225);
        SettingsSlider settingsSlider = new SettingsSlider(timer, 225, 225);
        settingsSlider.addChangeListener(e -> this.timer = settingsSlider.getValue());
        this.add(timerLabel);
        this.add(settingsSlider);

        SettingsLabel rowsLabel = new SettingsLabel(GAME_ROWS, 115, 325);
        SettingsTextField rowsTextField = new SettingsTextField(Integer.toString(rows), 225, 325);
        rowsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e ->
                this.rows = checkIntegerValue(rowsTextField.getText())
        );
        this.add(rowsLabel);
        this.add(rowsTextField);

        SettingsLabel colsLabel = new SettingsLabel(GAME_COLUMNS, 75, 425);
        SettingsTextField colsTextField = new SettingsTextField(Integer.toString(cols), 225, 425);
        colsTextField.getDocument().addDocumentListener((SimpleDocumentListener) e ->
                this.cols = checkIntegerValue(colsTextField.getText())
        );
        this.add(colsLabel);
        this.add(colsTextField);

        // TODO: - NICE TO HAVE
        //  Implement a check that verifies that the user
        //  does not insert an odd or <4 configuration
        /*
        if (!isConfigurationValid(rows, cols)) {
            JOptionPane.showMessageDialog(
                    null,
                    GAME_INVALID_CONFIGURATION_MESSAGE,
                    GAME_INVALID_CONFIGURATION_TITLE,
                    JOptionPane.ERROR_MESSAGE
            );
            this.setEnabled(false);
        }
         */

        this.setVisible(true);
    }

    /**
     * Checks whether the configuration that we get as an input
     * from the user is valid, otherwise we can not create the board.<br>
     * For the configuration to be valid we need at lest 4 tiles,
     * and if so, the total number of tiles must be even.
     *
     * @param rows    the number of rows
     * @param columns the number of columns
     * @return true or false based on whether the configuration is valid or not
     */
    private boolean isConfigurationValid(int rows, int columns) {
        int tiles = rows * columns;
        return tiles % 2 == 0 && tiles >= 4;
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
            JOptionPane.showMessageDialog(
                    null,
                    GAME_INSERT_NUMBER_MESSAGE,
                    GAME_INSERT_NUMBER_TITLE,
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    GAME_UNKNOWN_EXCEPTION_MESSAGE,
                    GAME_UNKNOWN_EXCEPTION_TITLE,
                    JOptionPane.ERROR_MESSAGE
            );
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
