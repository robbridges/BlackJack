package CardGenerator;

/**
 * Created by Robert on 9/26/2015.
 */
public enum CardValue {


    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private String cardValue;


    private CardValue(String value) {
        this.cardValue = value;
    }

    public String getValue() {
        return cardValue;
    }



}
