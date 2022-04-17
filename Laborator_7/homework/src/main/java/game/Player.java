package game;

import letters.Tile;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.*;


public class Player implements Runnable {
    private String name;
    private Game game;
    private int points;
    private int auxPoints;
    private boolean running;
    private Instant start;
    private int timeLimit = 60000;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.auxPoints = 0;
    }

    private boolean isAlpha(String word) {
        char[] chars = word.toCharArray();

        for (char character : chars) {
            if (!Character.isLetter(character)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return Scans a new word. If does not contain an extracted character, the player wont get points
     * If the word doesnt exist in the dictionary, the player wont get points
     * If the word doesnt contain only aplhabetic character, an error will occur
     * @throws InterruptedException thrown if the thread is intrerrupted
     * @throws NotAlphabeticException thrown if the string word is not alphabetic
     */
    private boolean submitWord() throws InterruptedException, NotAlphabeticException {
        List<Tile> extracted = game.getBag().extractTiles(10);
        Map<String, String> dictionary = game.getDictionary();
        boolean wordFound = false;
        this.auxPoints = 0;

        System.out.println("\n\n" + this.name + "'s turn");

        if (extracted.isEmpty()) {
            return false;
        }

        System.out.println("The letter you extracted are: ");
        for (Tile tile : extracted) {
            System.out.print(tile.getLetter() + " ");
        }
        System.out.println("");


        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter word");
        String word = myObj.nextLine();
        String[] arrayWord = word.split("");

        if(!isAlpha(word))
            throw new NotAlphabeticException();

        for (String s : arrayWord) {
            Boolean letterFound = false;
            for (Tile tile : extracted) {
                if ((s.equals(String.valueOf(tile.getLetter())))) {
                    letterFound = true;
                    this.auxPoints = this.auxPoints + tile.getPoints();
                }
            }
            if (!letterFound) {
                System.out.println("One ore more letters were not between the ones extracted");
                this.auxPoints = 0;
                return true;
            }
        }

        this.auxPoints = this.auxPoints * word.length();

        if (word.equals(dictionary.get(word))) {
            wordFound = true;
            System.out.println("Word found in dictionary");
            game.getBoard().addWord(this, word);
        }

        if (!wordFound) {
            System.out.println("Word not found in dictionary");
            this.auxPoints = 0;
        }

        Thread.sleep(50);


        return true;
    }

    /**
     * Overriden method that is called after a thread is started.
     * Starts a timer and counts the time if the thread is daemon
     * Submits a word and adds points otherwise
     */
    @Override
    public void run() {

        if (Thread.currentThread().isDaemon()) {
            start = Instant.now();
            System.out.println("The timer has started: 60 seconds");
            long timeElapsed = 0;
            while (true) {
                Instant finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                if (timeElapsed > this.timeLimit) {
                    System.out.println("The time limit for the game has ended");
                    System.exit(0);
                }
            }
        } else
            try {
                if (submitWord()) {
                    points = points + auxPoints;
                    System.out.println("Current points: " + this.points);
                }
            } catch (InterruptedException | NotAlphabeticException e) {
                e.printStackTrace();
            }

    }

    public Instant getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPoints() {
        return points;
    }

    public long getTimeLimit() {
        return this.timeLimit;
    }
}