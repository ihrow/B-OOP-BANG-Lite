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
        targetPlayer.addBlueCard(this);
    }
    @Override
    public void effect(Player player) {
        super.effect(player);
        System.out.print(ANSI_RED + "\uD83D\uDC6E You are in prison! " + ANSI_RESET);
        this.deck.addCard(this);
        player.removeBlueCard(this);
    }

    @Override
    public boolean didEscape(Player player) {
        int chance = this.deck.getRandom().nextInt(4) + 1;
        if (chance == 1) {
            System.out.println(ANSI_GREEN + "You escaped!" + ANSI_RESET);
            return true;
        }
        System.out.println(ANSI_RED + "You didn't escape!" + ANSI_RESET);
        return false;
    }
}
