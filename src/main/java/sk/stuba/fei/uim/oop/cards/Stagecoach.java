package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Stagecoach extends Card {
    public static final String CARD_NAME = ANSI_BROWN + "Stagecoach" + ANSI_RESET;
    public Stagecoach() {
        super(CARD_NAME);
    }

    @Override
    public void play() {
        System.out.println("Stagecoach!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played stagecoach " + targetPlayer.getName());
    }
}
