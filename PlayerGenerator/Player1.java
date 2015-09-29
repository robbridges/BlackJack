package PlayerGenerator;

import CardGenerator.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by Robert on 9/27/2015.
 */
public class Player1 implements Player {

    private String mName;

    public int getCurrentScore() {
        return currentScore;
    }

    private int currentScore;
    private int mHandsWon;
    private int bankCount;

    public ArrayList<Card> getPlayer1CardList() {
        return player1CardList;
    }

    private ArrayList<Card> player1CardList;
    Card card;


    public Player1 returnPlayer() {
        bankCount = 100;
        mName = askPlayersName();
        return this;
    }


    public String askPlayersName() {
        try( InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr))
         {
            System.out.println("Greetings, what is your name player1?");
             mName = reader.readLine();
            System.out.printf("I see, welcome to the table %s. " +
                    "Lets start you with %d chips \n", mName, getBankCount() );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mName;
    }

    public int getmScore() {
        return mScore;
    }



    public int getmHandsWon() {
        return mHandsWon;
    }

    public void setmHandsWon(int mHandsWon) {
        this.mHandsWon = mHandsWon;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
    public int getBankCount() {
        return bankCount;
    }

    public void setBankCount(int bankCount) {
        this.bankCount = bankCount;
    }

    public int setCurrentScore(ArrayList<Card> player1CardList) {

        for (Card card: player1CardList) {
            currentScore = 0;
            currentScore += getValue(card);
        }
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
    public boolean hasWon() {
        if (this.currentScore == 21) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void addCardsToHand(Card card) {
        arrayListCreate();
        player1CardList.add(card);
    }

    @Override
    public void showCurrentCards(ArrayList<Card> player1CardList) {
        arrayListCreate();
        System.out.println("Card list currently contains:");
        for (Card card : player1CardList) {
            System.out.printf("%s, of %s", card.getValue(), card.getSuit());
        }
    }

    @Override
    public void arrayListCreate() {
        if (player1CardList == null) {
            player1CardList = new ArrayList<>();
        }
    }


}
