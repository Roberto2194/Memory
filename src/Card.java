package src;

import javax.swing.*;
import java.util.Objects;

public class Card extends JButton {

    private final char front;

    private final char back = 'X';

    private boolean isShowing = false;

    public Card(char front) {
        this.front = front;
    }

    public boolean getIsShowing() {
        return isShowing;
    }

    public void setIsShowing(boolean showing) {
        isShowing = showing;
    }

    @Override
    public String toString() {
        if (this.isShowing) return Character.toString(this.front);
        else return Character.toString(this.back);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return Objects.equals(this.front, that.front);
    }

}
