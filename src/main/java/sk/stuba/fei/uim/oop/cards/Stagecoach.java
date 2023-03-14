package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Stagecoach extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Stagecoach" + ANSI_RESET;
    public Stagecoach(Deck deck) {
        super(CARD_NAME, deck);
    }

    @Override
    public void play(Player targetPlayer) {
        System.out.println("You have drawn 2 cards");
        for (int i = 0; i < 2; i++) {
            if (this.deck.isEmpty()) {
                System.out.println(ANSI_RED + "The deck is empty" + ANSI_RESET);
                return;
            }
            targetPlayer.addCard(this.deck.draw());
        }
    }
}
