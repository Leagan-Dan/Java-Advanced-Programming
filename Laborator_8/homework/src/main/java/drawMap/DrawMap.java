package drawMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawMap extends JPanel {
    final MainFrame frame;
    int mapWidth = 800, mapHeight = 800;
    BufferedImage image;
    Graphics2D offscreen;
    Coordinates coordinates;

    public DrawMap(MainFrame frame, Coordinates coordinates) {
        this.frame = frame;
        this.coordinates=coordinates;
        createOffscreenImage();
    }

    /**
     * Creates the background image
     */
    public void createOffscreenImage() {
        image = new BufferedImage(
                mapWidth, mapHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.GREEN);
        offscreen.fillRect(0, 0, mapWidth, mapHeight);

    }

    /**
     * Paints points on the map using the stored coordinates
     * @param graphics
     */
    public void paintMap(Graphics2D graphics){
        offscreen.setColor(Color.BLUE);
        for(int index=0;index<coordinates.vectorX.size();index++) {
            offscreen.fillOval(coordinates.vectorX.get(index), coordinates.vectorY.get(index), 10, 10);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, mapWidth, mapHeight);
        paintMap(graphics2D);

        graphics.drawImage(image, 0, 0, this);
    }
}
