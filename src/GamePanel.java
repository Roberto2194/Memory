package src;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    GamePanel(int rows, int cols) {
        this.setLayout(new GridLayout(rows, cols));

        this.add(new CardButton("icons/watermelon.png"));
        this.add(new CardButton("icons/mango.png"));
        this.add(new CardButton("icons/apple.png"));
        this.add(new CardButton("icons/avocado.png"));

        this.add(new CardButton("icons/orange.png"));
        this.add(new CardButton("icons/peach.png"));
        this.add(new CardButton("icons/plum.png"));
        this.add(new CardButton("icons/star-fruit.png"));

        this.add(new CardButton("icons/watermelon.png"));
        this.add(new CardButton("icons/mango.png"));
        this.add(new CardButton("icons/apple.png"));
        this.add(new CardButton("icons/avocado.png"));

        this.add(new CardButton("icons/orange.png"));
        this.add(new CardButton("icons/peach.png"));
        this.add(new CardButton("icons/plum.png"));
        this.add(new CardButton("icons/star-fruit.png"));

        this.setVisible(true);
    }

}
