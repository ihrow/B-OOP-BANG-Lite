package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Bang extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Bang \uD83D\uDCA5" + ANSI_RESET;
    public Bang(Deck deck) {
        super(CARD_NAME, deck);
    }

    @Override
    public void play(Player targetPlayer) {
        super.play(targetPlayer);
        Card isMissed = targetPlayer.haveMissedCard();
        if (isMissed != null) {
            targetPlayer.removeCard(isMissed);
            this.deck.addCard(isMissed);
            System.out.println("You missed the bang. \uD83D\uDC80");
        } else {
            targetPlayer.removeLife();
            System.out.println(targetPlayer.getName() + " lost a life. \uD83D\uDC94");
            System.out.println(targetPlayer.getName() + " has " + ANSI_RED + targetPlayer.getHealth() + ANSI_RESET + " lives left. \uD83D\uDC80");
            if (!targetPlayer.isAlive()) {
                System.out.println(targetPlayer.getName() + " is dead. ☠️");
            }
        }
    }
}
