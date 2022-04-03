package panels;
import mainFrame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel{
    final MainFrame frame;
    int canvasWidth = 800, canvasHeight = 800;
    BufferedImage image;
    Graphics2D offscreen;
    int rows, cols;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;


    public Canvas(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        // init(configPanel.getRows(), configPanel.getCols());
    }

    public void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void paintGrid(Graphics2D graphics) {
        offscreen.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX;
            int y1 = padY + col * cellWidth;
            int x2 = padX + boardHeight;
            int y2 = y1;
            offscreen.drawLine(y1, x1, y2, x2);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }


    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        repaint();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                drawStone(event.getX(), event.getY());
                repaint();
            }
        });
    }


    private void drawStone(int x, int y) {
        offscreen.setColor(Color.BLACK);

        int w=canvasWidth;
        int h=canvasHeight;
        offscreen.fillOval(x-10, y-10, w/32, h/32);
    }

    @Override
    public void update(Graphics graphics) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(graphics2D);
        //paintSticks(graphics2D);
        //paintStones(graphics2D);
        graphics.drawImage(image, 0, 0, this);
    }

}

