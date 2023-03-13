package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Missed extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Missed \uD83D\uDEAB" + ANSI_RESET;
    public Missed(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
    }
}

