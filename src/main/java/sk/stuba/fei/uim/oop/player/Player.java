package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;
import java.util.ArrayList;

public class Player {

    private final String name;
    private int lives;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.lives = 4;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return lives;
    }

    public ArrayList<Card> getAllCards() {
        return cards;
    }

    public boolean isAlive() {
        return lives > 0;
    }

}
