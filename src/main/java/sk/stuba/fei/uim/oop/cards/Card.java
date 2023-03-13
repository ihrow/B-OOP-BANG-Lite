package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public abstract class Card {
    public static final String ANSI_BROWN = "\033[33m"; // actually yellow
    public static final String ANSI_BLUE = "\033[34m";
    public static final String ANSI_RESET = "\033[0m";
    protected String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();

    public abstract void play(Player targetPlayer);

}
