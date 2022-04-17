package letters;

import java.util.*;
import java.util.stream.IntStream;

public class Bag {
    private Vector<Integer> numberOfTiles= new Vector<>(25);
    private Map<Character, Integer> points=new HashMap<>(25);
    private final List<Tile> tiles = new ArrayList<>();

    /**
     * Constructor for Bag class. Fills the number of tiles and points, and creates object of type Tile
     */
    public Bag() {

        fillNumberOfTiles();
        fillPoints();

        int indexVector=0;
        for (char character = 'a'; character <= 'z'; character++) {

            char finalCharacter = character;
            Tile[] tileStream = IntStream.rangeClosed(1, numberOfTiles.get(indexVector))
                    .mapToObj(i -> new Tile(finalCharacter, points.get(finalCharacter)))
                    .toArray(Tile[]::new);

            Collections.addAll(tiles, tileStream);

            indexVector++;
        }
        for (Tile tile:tiles)
            System.out.println(tile.getLetter() + " "  +tile.getPoints());

    }

    /**
     * Fills the vector that contains the number of tiles for each letter
     */
    public void fillNumberOfTiles(){
        for(int index=0;index<25;index++){
            numberOfTiles.add(9);
            numberOfTiles.add(2);
            numberOfTiles.add(2);
            numberOfTiles.add(4);
            numberOfTiles.add(12);
            numberOfTiles.add(2);
            numberOfTiles.add(3);
            numberOfTiles.add(2);
            numberOfTiles.add(9);
            numberOfTiles.add(1);
            numberOfTiles.add(1);
            numberOfTiles.add(4);
            numberOfTiles.add(2);
            numberOfTiles.add(6);
            numberOfTiles.add(8);
            numberOfTiles.add(2);
            numberOfTiles.add(1);
            numberOfTiles.add(6);
            numberOfTiles.add(4);
            numberOfTiles.add(6);
            numberOfTiles.add(4);
            numberOfTiles.add(2);
            numberOfTiles.add(2);
            numberOfTiles.add(1);
            numberOfTiles.add(2);
            numberOfTiles.add(1);

        }
    }

    /**
     * Fills the hashmap that contains the number of points for each letter
     */
    public void fillPoints(){
        this.points.put('a',1);
        this.points.put('b',3);
        this.points.put('c',3);
        this.points.put('d',2);
        this.points.put('e',1);
        this.points.put('f',4);
        this.points.put('g',2);
        this.points.put('h',4);
        this.points.put('i',1);
        this.points.put('j',8);
        this.points.put('k',5);
        this.points.put('l',1);
        this.points.put('m',3);
        this.points.put('n',1);
        this.points.put('o',1);
        this.points.put('p',3);
        this.points.put('q',10);
        this.points.put('r',1);
        this.points.put('s',1);
        this.points.put('t',1);
        this.points.put('u',1);
        this.points.put('v',4);
        this.points.put('w',4);
        this.points.put('x',8);
        this.points.put('y',4);
        this.points.put('z',10);

    }

    /**
     * Extracts and removes a number of tiles from the bag
     * @param howMany the number of extracted tiles
     * @return the tiles that were extracted
     */
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();

        for (int index = 0; index < howMany; index++) {
            if (tiles.isEmpty()) {
                break;
            }
            Collections.shuffle(tiles);
            extracted.add(tiles.get(0));
            tiles.remove(0);
        }
        System.out.println("Number of tiles remaining: " + tiles.size());
        return extracted;
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}