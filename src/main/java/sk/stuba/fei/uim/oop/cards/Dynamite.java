package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Dynamite extends Card {
    public static final String CARD_NAME = ANSI_BLUE + "Dynamite" + ANSI_RESET;
    public Dynamite() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Dynamite!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Dynamite " + targetPlayer.getName());
    }
}
