package src.board;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import static src.utility.GameIcons.*;

/**
 * The Card ADT whose goal is to mimic the behaviour of an actual card.
 * It has two sides, both having an icon attached to it: frontIcon and backIcon.
 */
public class Card extends JButton {

    private final ImageIcon frontIcon;
    private final ImageIcon backIcon = scaleIcon(GAME_CARD_BACK);
    private boolean isShowing;

    public Card(String frontIcon) {
        this.frontIcon = scaleIcon(frontIcon);
        this.setName(frontIcon); // setting as a name the icon path
        this.setFocusable(false); // removes the dotted lines around the icon
        this.setBackground(Color.white);
        this.showBack(); // cards start face down
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void showFront() {
        this.setIcon(this.frontIcon);
        isShowing = true;
    }

    public void showBack() {
        this.setIcon(this.backIcon);
        isShowing = false;
    }

    public boolean getIsShowing() {
        return isShowing;
    }

    public ImageIcon getFrontIcon() {
        return frontIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return Objects.equals(this.getName(), that.getName());
    }

    private ImageIcon scaleIcon(String icon) {
        return new ImageIcon(new ImageIcon(icon).getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH));
    }

}
