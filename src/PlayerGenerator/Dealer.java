package PlayerGenerator;

import CardGenerator.Card;

import java.util.ArrayList;


/**
 * Created by Robert on 9/27/2015.
 */
public class Dealer implements Player {
    int firstCardScore;
    int secondCardScore;
    public String mName = "Dealer";
    public int mHandsWon;
    private int currentScore;
    private ArrayList<Card> dealerCards;
    Card card;
    public int aceDevalueCount;



    public int getmHandsWon() {
        return mHandsWon;
    }

    public void setmHandsWon(int mHandsWon) {
        this.mHandsWon = mHandsWon;
    }

    public int getmScore() {
        return mScore;
    }




    public int setCurrentScore(Card card) {
        currentScore += getValue(card);
        return currentScore;
    }

    @Override
    public int getValue(Card card) {
        String cardValue = card.getValue().toString();
        int cardNumericalValue = 0;
        switch (cardValue) {
            case "ONE": cardNumericalValue = 1;
                break;
            case "TWO": cardNumericalValue = 2;
                break;
            case "THREE": cardNumericalValue = 3;
                break;
            case "FOUR": cardNumericalValue = 4;
                break;
            case "FIVE": cardNumericalValue = 5;
                break;
            case "SIX": cardNumericalValue = 6;
                break;
            case "SEVEN": cardNumericalValue = 7;
                break;
            case "EIGHT": cardNumericalValue = 8;
                break;
            case "NINE": cardNumericalValue = 9;
                break;
            case "TEN": cardNumericalValue = 10;
                break;
            case "JACK": cardNumericalValue = 10;
                break;
            case "QUEEN": cardNumericalValue = 10;
                break;
            case "KING": cardNumericalValue = 10;
                break;
            case "ACE": cardNumericalValue = 11;
                break;
            default: break;

        }
        return cardNumericalValue;
    }

    @Override
    public boolean isDealtAce(Card card) {
        if (getValue(card) == 11) {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public String getmName() {
        return mName;
    }

    @Override
    public int getCurrentScore() {
        return currentScore;
    }

    @Override
    public int getAceDevalueCount() {
        return aceDevalueCount;
    }

    @Override
    public void setAceDevalueCount(int aceDevalueCount) {
        this.aceDevalueCount = aceDevalueCount;

    }


    @Override
    public void addCardsToHand(Card card) {
        arrayListCreate();
        dealerCards.add(card);
    }

    @Override
    public void showCurrentCards(ArrayList<Card> dealerCards) {
        arrayListCreate();
        System.out.println("Card list currently contains:");
        for (Card card : dealerCards) {
            System.out.printf("%s, of %s \n", card.getValue(), card.getSuit());
        }
    }



    public void arrayListCreate() {
        if (dealerCards == null) {
            dealerCards = new ArrayList<>();
        }
    }




    public ArrayList<Card> getDealerCards() {
        return dealerCards;
    }
}
