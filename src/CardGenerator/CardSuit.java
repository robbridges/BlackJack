package CardGenerator;

/**
 * Created by Robert on 9/26/2015.
 */
public enum CardSuit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");


    private String suit;

    private CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
