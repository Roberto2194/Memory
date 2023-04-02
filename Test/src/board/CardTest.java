package src.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static src.utility.GameIcons.GAME_POMEGRANATE;

class CardTest {

    Card card;

    @BeforeEach
    void setUp() {
        card = new Card(GAME_POMEGRANATE);
    }

    @Test
    void showFront() {
        card.showFront();
        // show front sets the icon we've initialized the class with
        assertEquals(card.getIcon(), card.getFrontIcon());
    }

    @Test
    void showBack() {
        card.showBack();
        // show back sets the default back icon
        assertEquals(card.getIcon(), card.getBackIcon());
    }

    @Test
    void getIsShowingTrueCase() {
        card.showFront();
        assertTrue(card.getIsShowing());
    }

    @Test
    void getIsShowingFalseCase() {
        card.showBack();
        assertFalse(card.getIsShowing());
    }

}