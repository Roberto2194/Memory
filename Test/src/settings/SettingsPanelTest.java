package src.settings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsPanelTest {

    SettingsPanel settingsPanel;

    @BeforeEach
    void setUp() {
        int timer = 5;
        int rows = 4;
        int cols = 4;
        settingsPanel = new SettingsPanel(timer, rows, cols);
    }

    @Test
    void getTimer() {
        int timer = settingsPanel.getTimer();
        assertEquals(5, timer);
    }

    @Test
    void getRows() {
        int rows = settingsPanel.getRows();
        assertEquals(4, rows);
    }

    @Test
    void getCols() {
        int cols = settingsPanel.getCols();
        assertEquals(4, cols);
    }

}