package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;

import static sk.stuba.fei.uim.oop.utility.Colors.*;

public class Indians extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Indians" + ANSI_RESET;
    public Indians(Deck deck) {
        super(CARD_NAME, deck);}
    @Override
    public void play(Player targetPlayer) {
        ArrayList<Card> playerHand = targetPlayer.getAllCards();
        for (int i = 0; i < playerHand.size(); i++) {
            Card card = playerHand.get(i);
            if (card instanceof Bang) {
                System.out.println(ANSI_YELLOW_B + targetPlayer.getName() + ANSI_RESET + " escaped from the " + ANSI_YELLOW_B + "Indians" + ANSI_RESET + " with a " + ANSI_YELLOW_B + "Bang" + ANSI_RESET + " card.");
                this.deck.addCard(card);
                playerHand.remove(card);
                return;
            }
        }
        this.effect(targetPlayer);
    }

    @Override
    public void effect(Player targetPlayer) {
        targetPlayer.removeLife();
    }
}
