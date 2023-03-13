package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Prison extends Card {
    public static final String CARD_NAME = ANSI_BLUE + "Prison" + ANSI_RESET;
    public Prison() {
        super(CARD_NAME);
    }
    @Override
    public void play() {
        System.out.println("Prison!");
    }
    @Override
    public void play(Player targetPlayer) {
        System.out.println("You played Prison against " + targetPlayer.getName());
    }
}
