package src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardButton extends JButton {

    private final ImageIcon frontIcon;
    private final ImageIcon backIcon = new ImageIcon("icons/card_back.png");
    private boolean isShowing = false;

    CardButton(String icon, ActionListener actionListener) {
        frontIcon = new ImageIcon(new ImageIcon(icon)
                .getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)); // scales the icon
        this.setIcon(new ImageIcon(frontIcon.getImage()));
        this.setFocusable(false); // removes the dotted lines around the icon
        this.setBackground(Color.white);
        this.addActionListener(actionListener);
        Border border = BorderFactory.createLineBorder(Color.black); // creates a border for the label
        this.setBorder(border);
    }

    public boolean getIsShowing() {
        return isShowing;
    }

    public void setIsShowing(boolean showing) {
        isShowing = showing;
    }

}
