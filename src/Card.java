package src;

import java.util.Objects;

/**
 * A Card ADT
 */
public class Card {

    private final String faceUp;

    private final String faceDown;

    public Card(String faceUp, String faceDown) {
        this.faceUp = faceUp;
        this.faceDown = faceDown;
    }

    public String getFaceUp() {
        return faceUp;
    }

    public String getFaceDown() {
        return faceDown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null) { return false; }
        if (this.getClass() != o.getClass()) { return false; }
        Card that = (Card) o;
        if (!Objects.equals(this.faceUp, that.faceUp)) { return false; }
        if (!Objects.equals(this.faceDown, that.faceDown)) { return false; }
        return true;
    }

}
