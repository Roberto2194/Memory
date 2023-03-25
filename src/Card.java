package src;

import javax.swing.*;

public class Card {

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

}
