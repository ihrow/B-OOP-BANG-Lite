package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Indians extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Indians" + ANSI_RESET;
    public Indians() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Indians!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Indians " + targetPlayer.getName());
    }
}
