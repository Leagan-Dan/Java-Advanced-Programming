package letters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Bag {
    private final List<Tile> tiles = new ArrayList<>();
    public Bag() {
        for (char character = 'a'; character < 'z'; character++) {

            char finalCharacter = character;
            Tile[] tileStream = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new Tile(finalCharacter, i))
                    .toArray(Tile[]::new);

            Collections.addAll(tiles, tileStream);

        }
    }
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