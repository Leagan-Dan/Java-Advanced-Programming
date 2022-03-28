package panels;

import mainFrame.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigurationPanel extends JPanel {
    private int rows;
    private int cols;
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinnerRowsCols;

    public ConfigurationPanel(MainFrame frame) {
        this.frame = frame;
        this.rows=10;
        this.cols=10;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerRowsCols= new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton createButton = new JButton("Create");

        add(label);
        add(spinner);
        add(spinnerRowsCols);
        add(createButton);

        createButton.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent event){
        System.out.println("create");
        this.rows=10;
        this.cols=10;
        int valueSpinner = (Integer) spinner.getValue();
        int valueSpinnerRowsCols = (Integer) spinnerRowsCols.getValue();
        frame.canvas.init(valueSpinnerRowsCols,valueSpinnerRowsCols);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
