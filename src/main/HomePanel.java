package src.main;

import javax.swing.*;
import static src.utility.GameColors.*;
import static src.utility.GameConstants.*;
import static src.utility.GameIcons.*;

/**
 * The Panel seen at the start of the App.
 */
public class HomePanel extends JPanel {

    public HomePanel() {
        this.setLayout(null);
        this.setBackground(GAME_BLUE_COLOR);
        // TITLE LABEL
        TitleLabel titleLabel = new TitleLabel(GAME_TITLE, 175, GAME_MEMORY_LOGO);
        this.add(titleLabel);

        this.setVisible(true);
    }

}
