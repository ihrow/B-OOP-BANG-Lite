package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Missed extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Missed" + ANSI_RESET;
    public Missed() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Missed!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("Missed!");
    }
}

