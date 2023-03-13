package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Barrel extends Card {
    public static final String CARD_NAME = ANSI_BLUE_B + "Barrel \uD83D\uDEE2️" + ANSI_RESET;
    public Barrel(Deck deck) {
        super(CARD_NAME, deck);
    }

    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played " + CARD_NAME + " card.");
    }
}
