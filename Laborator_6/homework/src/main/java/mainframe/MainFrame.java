package mainframe;
import panels.*;
import panels.Canvas;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigurationPanel configPanel;
    ControlPanel controlPanel;
    public Canvas canvas;


    public MainFrame() {
        super("My Game");
        setPreferredSize(new Dimension(800, 900));
        init();
    }

    /**
     * Initializes the main frame, adding the 3 components
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas(this);
        configPanel = new ConfigurationPanel(this);
        controlPanel=new ControlPanel(this);

        add(configPanel, NORTH);
        add(canvas, CENTER);
        add(controlPanel,SOUTH);

        pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
