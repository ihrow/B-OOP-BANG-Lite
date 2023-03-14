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
        Card isBarrel = targetPlayer.haveBarrelCardPlayed();
        if (isBarrel != null) {
            boolean didBarrelSave = isBarrel.didSave(targetPlayer);
            if (didBarrelSave) {
                return;
            }
        }
        Card isMissed = targetPlayer.haveMissedCard();
        if (isMissed != null) {
            isMissed.effect(targetPlayer);
            return;
        }
        this.effect(targetPlayer);
    }

    @Override
    public void effect(Player targetPlayer) {
        targetPlayer.removeLife();
        this.deck.addCard(this);
        System.out.print(ANSI_YELLOW_B + targetPlayer.getName() + ANSI_RESET + " lost a life ");
        System.out.println("and has " + ANSI_RED + targetPlayer.getHealth() + ANSI_RESET + " ❤️ left.\n");
        if (!targetPlayer.isAlive()) {
            System.out.println(targetPlayer.getName() + " is dead. ☠️");
        }
    }
}
