package drawMap;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    public DrawMap drawMap;
    private Coordinates coordinates;

    public MainFrame(Coordinates coordinates){
        super("Map");
        this.coordinates=coordinates;
        setPreferredSize(new Dimension(800, 800));
        init();
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawMap=new DrawMap(this, this.coordinates);
        add(drawMap,CENTER);
        pack();
    }
}
