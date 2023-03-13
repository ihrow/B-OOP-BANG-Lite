package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Beer extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Beer" + ANSI_RESET;
    public Beer() {
        super(CARD_NAME);
    }

    @Override
    public void play() {
        System.out.println("You drink a beer and feel better.");
    }

    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Beer " + targetPlayer.getName());
    }
}
