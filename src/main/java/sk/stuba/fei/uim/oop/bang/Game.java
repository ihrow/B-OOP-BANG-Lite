package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.deck.Deck;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;
import static sk.stuba.fei.uim.oop.utility.Colors.*;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentPlayer;
    private final Deck deck;

    public Game() {
        this.deck = new Deck();
        this.deck.shuffle();

        System.out.println(ANSI_RED_B + "\uD83C\uDF35 Bang! Bang! Bang! \uD83D\uDCA5" + ANSI_RESET);
        int numberOfPlayers = 0;
        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            numberOfPlayers = KeyboardInput.readInt(ANSI_GREEN + "\uD83E\uDD20 Enter amount of players (2-4)" + ANSI_RESET);
        }
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players.add(new Player(KeyboardInput.readString("Enter " + (i + 1) + " player name")));
        }

        // Each player starts with 4 cards from the deck
        for (Player player : this.players) {
            for (int i = 0; i < 4; i++) {
                player.addCard(this.deck.draw());
            }
        }

        this.startGame();
    }

    private void checkActivePlayers() {
        ArrayList<Player> activePlayers = new ArrayList<>();
        for (Player player : this.players) {
            if (player.isAlive()) {
                activePlayers.add(player);
            }
            else {
                this.putCardsBackToTheDeck(player);
            }
        }
        this.players = activePlayers;
    }

    private void putCardsBackToTheDeck(Player deadPlayer) {
        ArrayList<Card> cards = deadPlayer.removeAllCards();
        for (Card card : cards) {
            this.deck.addCard(card);
        }
    }

    private int getNumberOfActivePlayers() {
        this.checkActivePlayers();
        int numberOfActivePlayers = 0;
        for (Player player : this.players) {
            if (player.isAlive()) {
                numberOfActivePlayers++;
            }
        }
        return numberOfActivePlayers;
    }
    private void startGame() {
        System.out.println(ANSI_YELLOW_BI + "\n\uD83D\uDC02 Yeehaw! It's time to start a game of Bang!" + ANSI_RESET);
        int index = 1;
        while (this.getNumberOfActivePlayers() > 1) {
            Player activePlayer = this.players.get(this.currentPlayer);
            this.announceTurn(activePlayer, (index++ % 10));
            this.makeTurn(activePlayer);
            if(this.currentPlayer == this.players.size()) this.currentPlayer--;
            this.currentPlayer = (this.currentPlayer + 1) % this.players.size();
        }
        System.out.println(ANSI_YELLOW_BI + "The game is over! Congratulations to the winner!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "The winner is " + ANSI_RED_B + this.players.get(0).getName() + ANSI_RESET);
    }

    private void announceTurn(Player activePlayer, int index) {
        // only the following strings are generated by AI
        String[] TURN_VARIATIONS = {
                "The gunslinger's showdown is about to begin, and [player] is up next in the action!",
                "Hold on to your hats, folks! [player] is about to make their move in this wild west adventure.",
                "The dust is settling, and it looks like [player] is next in line to take their turn.",
                "Looks like it's time for [player] to reveal their true colors and show their hand.",
                "The tension is rising, and all eyes are on [player] as they plan their next move in this western standoff.",
                "The outlaws are on the prowl, and [player] is next in their sights. Will they make it out alive?",
                "The sheriff's badge is shining bright, and [player] is ready to uphold the law in this dusty town.",
                "The saloon doors swing open, and [player] steps up to take their turn in this epic western adventure.",
                "The sound of gunfire echoes in the distance, and it's [player]'s turn to join the fray and take on the competition.",
                "The sun is setting on this western town, and [player] is ready to make their mark in the history books."
        };
        String turnAnnouncement = TURN_VARIATIONS[index].replace("[player]", ANSI_RED_B + activePlayer.getName() + ANSI_PURPLE);
        System.out.println(ANSI_PURPLE + "\n\uD83D\uDCE2 " + turnAnnouncement + ANSI_RESET);
    }

    private void makeTurn(Player activePlayer) {
        /*
            Drawing cards - at the beginning of his turn, the given player draws 2 cards from the deck.
            If he has blue cards (Prison, Dynamite) in front of him, their effect is excecuted as first.
         */

        // If he has blue cards (Prison, Dynamite) in front of him, their effect is excecuted as first.
        ArrayList<Card> blueCards = activePlayer.getPlayedBlueCards();

        for (int i = 0; i < blueCards.size(); i++) {
            Card card = blueCards.get(i);
            card.effect(activePlayer);

            if (card instanceof Prison) {
                if (!card.didEscape(activePlayer)) {
                    return;
                }
            }

            if (card instanceof Dynamite && activePlayer.getPlayedBlueCards().contains(card)) {
                this.moveCardToThePreviousPlayer(activePlayer, card);
            }

        }

        // Drawing cards - at the beginning of his turn, the given player draws 2 cards from the deck.
        for (int i = 0; i < 2; i++) {
            if (this.deck.isEmpty()) {
                System.out.println(ANSI_RED + "The deck is empty" + ANSI_RESET);
                break;
            }
            activePlayer.addCard(this.deck.draw());
        }
        this.selectCard(activePlayer);
        this.discardCards(activePlayer);
    }

    private void discardCards(Player player) {
        if (player.getAllCards().size() <= player.getHealth()) {
            return;
        }
        System.out.println("\n" + ANSI_GREEN + "You have " + ANSI_RED + player.getAllCards().size() + ANSI_GREEN + " cards in your hand, but " + ANSI_RED + player.getHealth() + ANSI_GREEN + " lives" + ANSI_RESET);
        System.out.println("You have to discard " + ANSI_RED + (player.getAllCards().size() - player.getHealth()) + ANSI_GREEN + " cards" + ANSI_RESET);
        for (int i = player.getAllCards().size(); i > player.getHealth(); i--) {
            player.displayCards();
            this.discardCard(player);
        }
    }

    private void discardCard(Player player) {
        int choice;
        while (true) {
            choice = KeyboardInput.readInt(ANSI_GREEN + "\uD83D\uDD22 Enter card number to discard" + ANSI_RESET);
             if (choice > player.getAllCards().size() || choice < 1) {
                System.out.println(ANSI_RED + "\uD83D\uDED1 Invalid card number" + ANSI_RESET);
            } else {
                Card card = player.getAllCards().get(choice - 1);
                player.removeCard(card);
                this.deck.addCard(card);
                System.out.println(ANSI_RED + "\uD83D\uDED1 You have discarded " + card.getName() + ANSI_RESET + "\n");
                return;
            }
        }
    }

    private void selectCard(Player activePlayer) {
        int choice;
        Card chosenCard;
        while (true) {
            if (this.getNumberOfActivePlayers() == 1) {
                return;
            }
            activePlayer.displayCards();
            choice = KeyboardInput.readInt(ANSI_GREEN + "\uD83D\uDD22 Enter card number to play or 0 to end turn" + ANSI_RESET);
            if (choice == 0) {
                System.out.println(ANSI_RED + "\uD83D\uDED1 You have ended your turn" + ANSI_RESET + "\n");
                break;
            } else if (activePlayer.getAllCards().size() == 0) {
                System.out.println(ANSI_RED + "\uD83C\uDCCF You have no cards left" + ANSI_RESET);
                break;
            }
            else if (choice > activePlayer.getAllCards().size() || choice < 0) {
                System.out.println(ANSI_RED + "❌ Wrong card number" + ANSI_RESET);
                continue;
            }
            chosenCard = activePlayer.getAllCards().get(choice - 1);
            this.selectPlayer(chosenCard, activePlayer);
        }
    }

    private void displayOpponents(Player activePlayer) {
        System.out.println("\n");
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i) == activePlayer) {
                continue;
            }
            System.out.println(ANSI_PURPLE + (i + 1) + ". " + ANSI_YELLOW_B + this.players.get(i).getName() + ANSI_GREEN + " with " + ANSI_RED_B + this.players.get(i).getHealth() + " lives" + ANSI_GREEN + " and " + ANSI_BLUE_B + this.players.get(i).getAllCards().size() + " cards." + ANSI_RESET);
        }
    }

    private void selectPlayer(Card chosenCard, Player activePlayer) {
        if (chosenCard instanceof Missed) {
            System.out.println(ANSI_RED + "❌ You can't play Missed card" + ANSI_RESET);
            return;
        } else if (chosenCard instanceof Barrel || chosenCard instanceof Beer || chosenCard instanceof Stagecoach || chosenCard instanceof Dynamite) {
            chosenCard.play(activePlayer);
            return;
        } else if (chosenCard instanceof Indians) {
            for (Player player : this.players) {
                if (player == activePlayer) {
                    continue;
                }
                chosenCard.play(player);
            }
            activePlayer.removeCard(chosenCard);
            this.deck.addCard(chosenCard);
            return;
        }

        int choice = -1;
        this.displayOpponents(activePlayer);
        while (choice < 1 || choice > getNumberOfActivePlayers() || choice == (this.players.indexOf(activePlayer) + 1)) {
            choice = KeyboardInput.readInt(ANSI_GREEN + "\uD83D\uDD22 Enter player number to play the card on" + ANSI_RESET);
        }
        Player opponent = this.players.get(choice - 1);
        if ( !(chosenCard instanceof CatBalou && opponent.getAllCards().isEmpty() && opponent.getPlayedBlueCards().isEmpty())
                && !(chosenCard instanceof Prison && opponent.isInPrison())) {
            activePlayer.removeCard(chosenCard);
        }
        chosenCard.play(opponent);
    }

    private void moveCardToThePreviousPlayer(Player activePlayer, Card card) {
        int index = this.players.indexOf(activePlayer);

        if (index == 0) {
            index = this.players.size() - 1;
        } else {
            index--;
        }
        Player newPlayerWithDynamite = this.players.get(index);
        newPlayerWithDynamite.addBlueCard(card);
        System.out.println(ANSI_YELLOW_BI + card.getName() + " has been moved to the " + newPlayerWithDynamite.getName() + ". Good luck! \uD83C\uDF40" + ANSI_RESET);
        activePlayer.removeBlueCard(card);
    }
}
