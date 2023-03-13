package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Bang extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Bang" + ANSI_RESET;
    public Bang() {
        super(CARD_NAME);
    }

    @Override
    /*
        Bang cards are the main way to reduce the health of your opponents.
     */
    public void play() {
        System.out.println("Bang!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You automatically played Missed " + targetPlayer.getName());
    }
}
