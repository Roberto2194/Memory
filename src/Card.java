package src;

import java.util.Objects;

public class Card {

    private final char faceUp;

    private final char faceDown = 'X';

    public Card(char faceUp) {
        this.faceUp = faceUp;
    }

    public char getFaceUp() {
        return faceUp;
    }

    public char getFaceDown() {
        return faceDown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Card that = (Card) o;
        if (!Objects.equals(this.faceUp, that.faceUp)) {
            return false;
        }
        if (!Objects.equals(this.faceDown, that.faceDown)) {
            return false;
        }
        return true;
    }

}
