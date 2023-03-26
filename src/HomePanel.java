package src;

import javax.swing.*;

import static src.utility.GameColors.GAME_BLUE_COLOR;
import static src.utility.GameConstants.GAME_TITLE;
import static src.utility.GameIcons.GAME_MEMORY_LOGO;

public class HomePanel extends JPanel {

    HomePanel() {
        this.setLayout(null);
        this.setBackground(GAME_BLUE_COLOR);
        // TITLE LABEL
        TitleLabel titleLabel = new TitleLabel(GAME_TITLE, 175, GAME_MEMORY_LOGO);
        this.add(titleLabel);

        this.setVisible(true);
    }

}
