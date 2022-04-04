package game;

import board.Board;
import letters.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Game {
    private static final Bag bag = new Bag();
    private final Board board = new Board();

    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() throws InterruptedException {

        while(!bag.getTiles().isEmpty()) {
            for (Player player : players) {
                Thread thread = new Thread(player);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        for(Player player:players){
            System.out.println(player.getName() + ": " + player.getPoints());
        }

    }

    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }
}