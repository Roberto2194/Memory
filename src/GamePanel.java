package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    GamePanel(int rows, int cols) {
        this.setLayout(new GridLayout(rows, cols));

        this.add(new CardButton("icons/pineapple.png", this));
        this.add(new CardButton("icons/watermelon.png", this));
        this.add(new CardButton("icons/coconut.png", this));
        this.add(new CardButton("icons/lime.png", this));

        this.add(new CardButton("icons/mango.png", this));
        this.add(new CardButton("icons/grapes.png", this));
        this.add(new CardButton("icons/pear.png", this));
        this.add(new CardButton("icons/plum.png", this));

        this.add(new CardButton("icons/pineapple.png", this));
        this.add(new CardButton("icons/watermelon.png", this));
        this.add(new CardButton("icons/coconut.png", this));
        this.add(new CardButton("icons/lime.png", this));

        this.add(new CardButton("icons/mango.png", this));
        this.add(new CardButton("icons/grapes.png", this));
        this.add(new CardButton("icons/pear.png", this));
        this.add(new CardButton("icons/plum.png", this));

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Card Button pressed");
        // cardButton.setEnabled(false);
    }

}
