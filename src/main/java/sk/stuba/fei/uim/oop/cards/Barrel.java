package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Barrel extends Card {
    public static final String CARD_NAME = ANSI_BLUE_B + "Barrel \uD83D\uDEE2️ " + ANSI_RESET;
    public Barrel(Deck deck) {
        super(CARD_NAME, deck);
    }

    @Override
    public void play(Player targetPlayer) {
        if(targetPlayer.addBlueCard(this)) targetPlayer.removeCard(this);
    }
    @Override
    public boolean didSave(Player targetPlayer) {
        int chance = this.deck.getRandom().nextInt(4) + 1;
        if (chance == 1) {
            System.out.println(ANSI_RED_B + targetPlayer.getName() + ": " + ANSI_PURPLE + "Hah! I knew I could count on this ol' barrel to protect me." + ANSI_RESET);
            return true;
        } else {
            System.out.println(ANSI_RED_B + targetPlayer.getName() + ": " + ANSI_RESET + "Darn, that " + ANSI_BLUE_B + " barrel" + ANSI_RESET + "didn't quite do the trick." + ANSI_RESET);
            return false;
        }
    }
}
