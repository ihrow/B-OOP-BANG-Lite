package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;

public class Board {
    private Deck deck;

    public Board(Player[] players) {
        this.deck = new Deck();
        this.deck.shuffle();

        // Each player starts with 4 cards from the deck
        for (Player player : players) {
            for (int i = 0; i < 4; i++) {
                player.addCard(this.deck.draw());
            }
        }
    }

    public void addCardToDeck(Card card) {
        this.deck.addCard(card);
    }
}
