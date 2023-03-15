package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import static sk.stuba.fei.uim.oop.utility.Colors.*;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;

public class Dynamite extends Card {
    public static final String CARD_NAME = ANSI_BLUE_B + "Dynamite \uD83E\uDDE8" + ANSI_RESET;
    public Dynamite(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println(ANSI_YELLOW_BI + "\nYou played " + ANSI_RESET + CARD_NAME + ANSI_YELLOW_BI + " card." + ANSI_RESET + "\n");
        targetPlayer.addBlueCard(this);
        targetPlayer.removeCard(this);
    }

    @Override
    public void effect(Player player) {
        super.effect(player);
        int chance = this.deck.getRandom().nextInt(8) + 1;
        if (chance == 1) {
            System.out.println("Booom! The dynamite has exploded!. \uD83D\uDCA5 \nYou lost " + ANSI_RED_B + "3 ❤️." + ANSI_RESET);
            for (int i = 0; i < 3; i++) {
                player.removeLife();
            }
            if (!player.isAlive()) {
                ArrayList<Card> cards = player.removeAllCards();
                for (Card card : cards) {
                    this.deck.addCard(card);
                }
                System.out.println(player.getName() + " is dead. ☠️");
            }
            System.out.println("You are left with " + ANSI_RED_B + player.getHealth() + ANSI_RESET + " lives.");
            player.removeBlueCard(this);
            this.deck.addCard(this);
        } else {
            System.out.println(ANSI_GREEN + "You survived. \uD83C\uDF89" + ANSI_RESET);
        }
    }
}
