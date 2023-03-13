package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import static sk.stuba.fei.uim.oop.utility.Colors.*;
import sk.stuba.fei.uim.oop.player.Player;

public class Dynamite extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Dynamite \uD83E\uDDE8" + ANSI_RESET;
    public Dynamite(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played " + CARD_NAME + " card.");
    }
}
