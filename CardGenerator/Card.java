package CardGenerator;

/**
 * Created by Robert on 9/26/2015.
 */
public class Card {

    private CardSuit suit;
    private CardValue value;

    public Card(CardValue value, CardSuit suit) {
        this.value= value;
        this.suit = suit;

    }


    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }
    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }
}
