package src;

import java.util.Objects;

public class Card {

    private final char front;

    private final char back = 'X';

    private boolean isShowing = false;

    public Card(char front) {
        this.front = front;
    }

    public char faceUp() {
        return front;
    }

    public char faceDown() {
        return back;
    }

    public char isShowing() {
        if (this.isShowing) return this.front;
        else return this.back;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
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
