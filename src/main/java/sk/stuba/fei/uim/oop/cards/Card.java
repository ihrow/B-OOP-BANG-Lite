package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;


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
        System.out.println("\n" + ANSI_YELLOW_BI + name + " on " + targetPlayer.getName() + ANSI_RESET);
    }

    public void effect(Player player) {
        System.out.println(ANSI_RED_B + "You have " + name + ANSI_RED_B + " card in front of you." + ANSI_RESET);
    }

    public boolean didSave(Player player) { return false; };
    public boolean didEscape(Player player) { return false; };
}
