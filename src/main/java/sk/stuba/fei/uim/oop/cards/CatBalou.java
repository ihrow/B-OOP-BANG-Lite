package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class CatBalou extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Cat Balou" + ANSI_RESET;
    public CatBalou() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Cat Balou!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Cat Balou against " + targetPlayer.getName());
    }
}
