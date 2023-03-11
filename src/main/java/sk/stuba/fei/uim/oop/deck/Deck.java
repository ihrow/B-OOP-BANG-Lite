package sk.stuba.fei.uim.oop.deck;

import sk.stuba.fei.uim.oop.cards.*;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
        this.addBlueCards();
        this.addBrownCards();
    }

    private void addBlueCards() {
        for (int i = 0; i < 3; i++) {
            this.deck.add(new Barrel());
        }
        for (int i = 0; i < 3; i++) {
            this.deck.add(new Prison());
        }
        this.deck.add(new Dynamite());
    }

    private void addBrownCards() {
        for (int i = 0; i < 30; i++) {
            this.deck.add(new Bang());
        }
        for (int i = 0; i < 15; i++) {
            this.deck.add(new Missed());
        }
        for (int i = 0; i < 8; i++) {
            this.deck.add(new Beer());
        }
        for (int i = 0; i < 6; i++) {
            this.deck.add(new CatBalou());
        }
        for (int i = 0; i < 4; i++) {
            this.deck.add(new Stagecoach());
        }
        for (int i = 0; i < 2; i++) {
            this.deck.add(new Indians());
        }
    }
}
