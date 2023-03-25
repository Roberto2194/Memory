package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    GamePanel() {
        this.setSize(800, 800);
        this.setLayout(new GridLayout(4, 4)); // the type of layout for our frame

        // TODO: - EVERY BUTTON IS A CARD AND WE CREATE AS MANY BUTTONS AS ROWS AND COLUMNS AS SELECTED BY THE USER
        this.add(new GameButton("New Game", Color.yellow, 250, this));
        this.add(new GameButton("New Game", Color.white, 250, this));
        this.add(new GameButton("New Game", Color.black, 250, this));
        this.add(new GameButton("New Game", Color.blue, 250, this));
        this.add(new GameButton("New Game", Color.yellow, 250, this));
        this.add(new GameButton("New Game", Color.white, 250, this));
        this.add(new GameButton("New Game", Color.black, 250, this));
        this.add(new GameButton("New Game", Color.blue, 250, this));
        this.add(new GameButton("New Game", Color.yellow, 250, this));
        this.add(new GameButton("New Game", Color.white, 250, this));
        this.add(new GameButton("New Game", Color.black, 250, this));
        this.add(new GameButton("New Game", Color.blue, 250, this));
        this.add(new GameButton("New Game", Color.yellow, 250, this));
        this.add(new GameButton("New Game", Color.white, 250, this));
        this.add(new GameButton("New Game", Color.black, 250, this));
        this.add(new GameButton("New Game", Color.blue, 250, this));

        //this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
