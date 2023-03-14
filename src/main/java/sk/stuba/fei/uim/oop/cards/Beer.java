package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Beer extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Beer \uD83C\uDF7B" + ANSI_RESET;
    public Beer(Deck deck) {
        super(CARD_NAME, deck);
    }

    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played " + name + " and gained " + ANSI_RED_B +  "two ❤️" + ANSI_RESET);
        targetPlayer.removeCard(this);
        targetPlayer.addTwoLives();
        this.deck.addCard(this);
    }
}
