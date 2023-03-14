package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;


public class Indians extends Bang {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Indians" + ANSI_RESET;
    public Indians(Deck deck) {
        super(deck);
        this.name = CARD_NAME;
    }
    @Override
    public void play(Player targetPlayer) {
        super.play(targetPlayer);
    }
}
