package src;

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

}
