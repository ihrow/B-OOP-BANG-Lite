package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Prison extends Card {
    public static final String CARD_NAME = ANSI_BLUE_B + "Prison \uD83D\uDD12" + ANSI_RESET;
    public Prison(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
        super.play(targetPlayer);
        targetPlayer.getBlueCards().add(this);
    }
}
