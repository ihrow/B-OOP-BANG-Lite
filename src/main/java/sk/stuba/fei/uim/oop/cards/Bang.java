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
        In our simplified version of the game, you can play an unlimited number of these cards during your turn.
     */
    public void play() {
        System.out.println("Bang!");
    }
    @Override
    public void play(Player opponent) {
        System.out.println("Bang!");
    }
}
