package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Game {
    private final Player[] players;

    public Game() {
        System.out.println("\uD83C\uDF35 Bang! Bang! Bang! \uD83D\uDCA5 \n");
        int numberOfPlayers = 0;
        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            numberOfPlayers = KeyboardInput.readInt("\uD83E\uDD20 Enter amount of players (2-4)");
        }
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player(KeyboardInput.readString("Enter " + (i + 1) + " player name"));
        }
    }

    private int getNumberOfActivePlayers() {
        int numberOfActivePlayers = 0;
        for (Player player : this.players) {
            if (player.isAlive()) {
                numberOfActivePlayers++;
            }
        }
        return numberOfActivePlayers;
    }
}
