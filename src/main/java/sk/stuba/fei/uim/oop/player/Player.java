package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;
import java.util.ArrayList;

public class Player {

    private final String name;
    private int lives;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.lives = 4;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return lives;
    }

    public ArrayList<Card> getAllCards() {
        return cards;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void removeLife() {
        lives--;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public ArrayList<Card> removeAllCards() {
        ArrayList<Card> cardsToDeck = this.cards;
        this.cards = new ArrayList<Card>();
        return cardsToDeck;
    }

}
