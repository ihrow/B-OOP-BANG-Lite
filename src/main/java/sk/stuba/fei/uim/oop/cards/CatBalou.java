package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import static sk.stuba.fei.uim.oop.utility.Colors.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class CatBalou extends Card {
    public static final String CARD_NAME = ANSI_YELLOW_B + "Cat Balou \uD83D\uDC08" + ANSI_RESET;
    public CatBalou(Deck deck) {
        super(CARD_NAME, deck);
    }
    @Override
    public void play(Player targetPlayer) {
        super.play(targetPlayer);

        int opponentsBlueCardSize = targetPlayer.getPlayedBlueCards().size();
        int opponentsHandSize = targetPlayer.getAllCards().size();

        if(opponentsHandSize == 0 && opponentsBlueCardSize == 0) {
            System.out.println("Opponent has no cards.");
            return;
        }
        this.deck.addCard(this);

        int firstChoice = chooseDiscardOption(opponentsHandSize, opponentsBlueCardSize);
        if (firstChoice == 1 && opponentsHandSize > 0) {
            int cardChoice = this.deck.getRandom().nextInt(opponentsHandSize);
            targetPlayer.removeCard(cardChoice);
        } else if (firstChoice == 2 && opponentsBlueCardSize > 0) {
            int cardChoice = this.deck.getRandom().nextInt(opponentsBlueCardSize);
            targetPlayer.removeBlueCard(cardChoice);
        }

    }

    private int chooseDiscardOption(int opponentsHandSize, int opponentsBlueCardSize) {
        if (opponentsHandSize == 0) {
            return 2;
        }
        if (opponentsBlueCardSize == 0) {
            return 1;
        }

        int choice = 0;
        while (choice < 1 || choice > 2) {
            System.out.println("1: Discard 1 card from opponent's hand.");
            System.out.println("2: Discard 1 opponent's card from the table.");
            choice = KeyboardInput.readInt(ANSI_GREEN + "\uD83E\uDD20 Choose what to do:" + ANSI_RESET);
        }
        return choice;
    }
}
