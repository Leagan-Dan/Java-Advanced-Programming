package game;

import letters.Tile;

import java.util.List;


public class Player implements Runnable {
    private String name;
    private Game game;
    private int points;
    private int auxPoints;
    private boolean running;

    public Player(String name) {
        this.name = name;
        this.points=0;
        this.auxPoints=0;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        this.auxPoints=0;
        String word="";
        for(Tile tile:extracted){
            word+=tile.getLetter();
            this.auxPoints=tile.getPoints();
        }
        this.auxPoints=this.auxPoints*extracted.size();

        game.getBoard().addWord(this, word);
        Thread.sleep(50);

        return true;
    }

    @Override
    public void run() {
        try {
            if(submitWord()){
                points=points+auxPoints;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
}