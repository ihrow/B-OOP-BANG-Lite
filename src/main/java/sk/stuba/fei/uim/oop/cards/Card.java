package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;

public abstract class Card {
    protected String name;
    protected Deck deck;

    public Card(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public void play(Player targetPlayer) {
        System.out.println("You played " + name + " on " + targetPlayer.getName());
    }
}
