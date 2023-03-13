package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;


public class Indians extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Indians" + ANSI_RESET;
    public Indians(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
        super.play(targetPlayer);
    }
}
