package game;

import board.Board;
import letters.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Game {
    private static final Bag bag = new Bag();
    private final Board board = new Board();

    public Map<String,String> dictionary= new HashMap<>();
    private final List<Player> players = new ArrayList<>();
    private int bestScore=0;
    private String winner;

    public Game() throws IOException {
        fillDictionary();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    /**
     * Creates a daemon thread, Timer, that counts the seconds since the game was started.
     * Creates a thread for every player and start it. If a thread is already running,
     * the other threads will wait.
     * Decides the winner of the game.
     * Prints the number of miliseconds the game lasted.
     */
    public void play() throws InterruptedException {

        Player timer = new Player("Timer");
        Thread threadTimer=new Thread(timer);
        threadTimer.setDaemon(true);
        threadTimer.start();


        while(!bag.getTiles().isEmpty()) {
            for (Player player : players) {
                Thread thread = new Thread(player);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Instant finish = Instant.now();
                long timeElapsed = Duration.between(timer.getStart(), finish).toMillis();
                System.out.println("Remaining time: " + (timer.getTimeLimit()-timeElapsed)/1000 + " seconds");
            }
        }


        for(Player player:players){
            System.out.println(player.getName() + ": " + player.getPoints());
            if(player.getPoints()>bestScore) {
                this.bestScore = player.getPoints();
                this.winner=player.getName();
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(timer.getStart(), finish).toMillis();
        System.out.println("The game lasted " + timeElapsed + " miliseconds");

        System.out.println("The winner is: " + this.winner);

    }

    public static void main(String args[]) throws InterruptedException, IOException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

    }

    /**
     * Fills the dictionary from a .txt file specified in the filePath
     * @throws IOException throws exception if the input file can't be found
     */
    public void fillDictionary() throws IOException {
        String filePath = "C:\\Users\\Dan\\Desktop\\WordSpell.txt";

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Integer key=0;
        while ((line = reader.readLine()) != null)
        {
            String value = line;
            this.dictionary.put(value,value);
            key++;
        }

        reader.close();
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Map<String,String> getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }
}