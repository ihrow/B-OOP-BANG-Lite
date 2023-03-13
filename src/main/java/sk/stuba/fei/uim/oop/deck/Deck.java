package sk.stuba.fei.uim.oop.deck;

import sk.stuba.fei.uim.oop.cards.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
        this.addBlueCards();
        this.addBrownCards();
    }

    private void addBlueCards() {
        for (int i = 0; i < 2; i++) {
            this.deck.add(new Barrel(this));
        }
        for (int i = 0; i < 3; i++) {
            this.deck.add(new Prison(this));
        }
        this.deck.add(new Dynamite(this));
    }

    private void addBrownCards() {
        for (int i = 0; i < 30; i++) {
            this.deck.add(new Bang(this));
        }
        for (int i = 0; i < 15; i++) {
            this.deck.add(new Missed(this));
        }
        for (int i = 0; i < 8; i++) {
            this.deck.add(new Beer(this));
        }
        for (int i = 0; i < 6; i++) {
            this.deck.add(new CatBalou(this));
        }
        for (int i = 0; i < 4; i++) {
            this.deck.add(new Stagecoach(this));
        }
        for (int i = 0; i < 2; i++) {
            this.deck.add(new Indians(this));
        }
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public Card draw() {
        return this.deck.remove(0);
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}
