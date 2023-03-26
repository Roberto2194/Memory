package src;

import javax.swing.*;
import java.awt.*;

import static src.GameIcons.*;

public class CardButton extends JButton {

    private final ImageIcon frontIcon;
    private final ImageIcon backIcon = scaleIcon(GAME_CARD_BACK);
    private boolean isShowing;

    CardButton(String frontIcon) {
        this.frontIcon = scaleIcon(frontIcon);
        this.setFocusable(false); // removes the dotted lines around the icon
        this.setBackground(Color.white);
        this.showBack(); // cards start face down
        this.addActionListener(e -> showFront());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void showFront() {
        this.setIcon(new ImageIcon(frontIcon.getImage()));
        isShowing = true;
    }

    public void showBack() {
        this.setIcon(new ImageIcon(backIcon.getImage()));
        isShowing = false;
    }

    public boolean getIsShowing() {
        return isShowing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        CardButton that = (CardButton) o;
        return this.frontIcon == that.frontIcon;
    }

    private ImageIcon scaleIcon(String icon) {
        return new ImageIcon(new ImageIcon(icon).getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH));
    }

}
