package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Barrel extends Card {
    public static final String CARD_NAME = ANSI_BLUE + "Barrel" + ANSI_RESET;
    public Barrel() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Barrel!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Barrel " + targetPlayer.getName());
    }
}
