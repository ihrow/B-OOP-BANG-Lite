package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.*;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

import java.util.ArrayList;

public class Player {

    private final String name;
    private int lives;
    private ArrayList<Card> cards;
    private final ArrayList<Card> playedBlueCards;

    public Player(String name) {
        this.name = name;
        this.lives = 4;
        this.cards = new ArrayList<>();
        this.playedBlueCards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.lives;
    }

    public ArrayList<Card> getAllCards() {
        return this.cards;
    }

    public boolean isAlive() {
        return this.lives > 0;
    }

    public void removeLife() {
        this.lives--;
        System.out.print(ANSI_YELLOW_B + this.getName() + ANSI_RESET + " lost a life ");
        System.out.println("and has " + ANSI_RED + this.getHealth() + ANSI_RESET + " ❤️ left.");
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public ArrayList<Card> removeAllCards() {
        ArrayList<Card> cardsToDeck = this.cards;
        this.cards = new ArrayList<>();
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
        System.out.println("\n" + ANSI_CYAN + this.name + ANSI_RESET + ", you have " + ANSI_RED_B + this.lives + ANSI_RESET + " ❤️ left");
        System.out.println("Your cards: ");
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println("Card " + (i + 1) + ": " + this.cards.get(i).getName());
        }
    }

    public ArrayList<Card> getPlayedBlueCards() {
        return this.playedBlueCards;
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }
    public void removeCard(int index) {
        System.out.println(ANSI_RED_B + this.cards.get(index).getName() + " removed." + ANSI_RESET);
        this.cards.remove(index);
    }

    public void addTwoLives() {
        this.lives += 2;
    }

    public boolean addBlueCard(Card playedCard) {
        for (Card card : this.playedBlueCards) {
            if (playedCard.getName().equals(card.getName())) {
                System.out.println("A player already has this card in front of him.");
                return false;
            }
        }
        this.playedBlueCards.add(playedCard);
        return true;
    }

    public boolean isInPrison() {
        for (Card card : this.playedBlueCards) {
            if (card instanceof Prison) {
                return true;
            }
        }
        return false;
    }

    public void removeBlueCard(Card card) {
        this.playedBlueCards.remove(card);
    }

    public void removeBlueCard(int cardChoice) {
        System.out.println(ANSI_RED_B + this.playedBlueCards.get(cardChoice).getName() + " removed." + ANSI_RESET);
        this.playedBlueCards.remove(cardChoice);
    }
}
