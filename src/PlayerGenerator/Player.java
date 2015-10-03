package PlayerGenerator;

import CardGenerator.Card;

import java.util.ArrayList;

/**
 * Created by Robert on 9/27/2015.
 */
public interface Player {
    public String mName = "";
    public int mScore = 0;
    public int mHandsWon = 0;
    public int mBet= 0;
    public int bankCount = 0;
    public int aceDevalueCount = 0;





    public void addCardsToHand(Card card);

    public void showCurrentCards(ArrayList<Card> cardList);

    public void arrayListCreate();

    public int getValue(Card card);

    public int tallyCurrentScore(Card card);

    public boolean isDealtAce(Card card);

    public String getmName();

    public int getCurrentScore();

    public void setCurrentScore(int currentScore);










}
