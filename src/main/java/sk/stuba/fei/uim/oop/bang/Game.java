package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Game {
    private final Player[] players;
    private Board board;

    public Game() {
        System.out.println("\uD83C\uDF35 \033[31;1m Bang! Bang! Bang! \033[0m \uD83D\uDCA5 \n");
        int numberOfPlayers = 0;
        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            numberOfPlayers = KeyboardInput.readInt("\uD83E\uDD20 \033[32m Enter amount of players (2-4)\033[0m");
        }
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player(KeyboardInput.readString("Enter " + (i + 1) + " player name"));
        }
        this.startGame();
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

    private void startGame() {
        System.out.println("\n \uD83D\uDC02 \033[33;1;3m Yeehaw! It's time to start a game of Bang! \033[0m");
        this.board = new Board(this.players);
    }
}
