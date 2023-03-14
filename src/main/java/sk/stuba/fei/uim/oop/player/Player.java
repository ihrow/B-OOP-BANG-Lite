package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.Missed;

import static sk.stuba.fei.uim.oop.utility.Colors.*;
import java.util.ArrayList;

public class Player {

    private final String name;
    private int lives;
    private ArrayList<Card> cards;
    private ArrayList<Card> playedBlueCards;

    public Player(String name) {
        this.name = name;
        this.lives = 4;
        this.cards = new ArrayList<Card>();
        this.playedBlueCards = new ArrayList<Card>();
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

    public void displayCards() {
        if (!this.playedBlueCards.isEmpty()) {
            System.out.println("Blue cards in front of you:");
            for (Card card : this.playedBlueCards) {
                System.out.print(ANSI_BLUE + card.getName() + " ");
            }
            System.out.println(ANSI_RESET);
        }
        System.out.println("Playable cards:");
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println("Card " + (i + 1) + ": " + cards.get(i).getName());
        }
    }

    public ArrayList<Card> getBlueCards() {
        return this.playedBlueCards;
    }

    public boolean checkCard(Card checkCard) {
        for (Card card : this.cards) {
            if (card.getName().equals(checkCard.getName())) {
                return true;
            }
        }
        return false;
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }
    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public void addTwoLives() {
        this.lives += 2;
    }

    public Card haveMissedCard() {
        for (Card card : this.cards) {
            if (card instanceof Missed) {
                return card;
            }
        }
        return null;
    }

    public void addBlueCard(Card card) {
        this.playedBlueCards.add(card);
    }

    public void removeBlueCard(Card card) {
        this.playedBlueCards.remove(card);
    }
}
