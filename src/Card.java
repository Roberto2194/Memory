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
        this.isShowing = true;
        return front;
    }

    public char faceDown() {
        this.isShowing = false;
        return back;
    }

    public boolean isShowing() {
        return isShowing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Card that = (Card) o;
        if (!Objects.equals(this.front, that.front)) return false;
        if (!Objects.equals(this.back, that.back)) return false;
        return true;
    }

}
