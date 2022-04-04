package panels;

import mainframe.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Initializes the control panel, adding the 3 buttons
     */
    private void init() {

        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(event -> {
            try {
                loadGame(event);
            } catch (LoadException exception) {
                exception.printStackTrace();
            }
        });
        saveBtn.addActionListener(this::saveGame);
    }

    /**
     * Exits the game
     * @param event indicates that the button "Exit" was pressed"
     */
    private void exitGame(ActionEvent event) {
        frame.dispose();
    }

    /**
     * Loads a PNG file from the path chosen, and sets that image on the main frame
     * @param event indicates that the button "Load" was pressed
     */
    private void loadGame(ActionEvent event) throws LoadException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("PNG", "png");
        chooser.setFileFilter(extension);
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {

            if(!chooser.getSelectedFile().exists())
                throw new LoadException();
            try {
                frame.getCanvas().setImage(ImageIO.read(chooser.getSelectedFile()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        frame.canvas.init(0,0);
        System.out.println("game loaded");
    }

    /**
     * Saves the image from the frame as a PNG, to the path chosen
     * @param event indicates that the button "Save" was pressed
     */
    private void saveGame(ActionEvent event){
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(chooser.getSelectedFile().getPath()));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        System.out.println("game saved");
    }

}
