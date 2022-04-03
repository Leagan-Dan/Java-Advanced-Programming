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
    JSpinner spinnerCols;

    public ConfigurationPanel(MainFrame frame) {
        this.frame = frame;
        this.rows=10;
        this.cols=10;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols= new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton createButton = new JButton("Create");

        add(label);
        add(spinner);
        add(spinnerCols);
        add(createButton);

        createButton.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent event){
        this.rows=10;
        this.cols=10;
        int valueSpinnerRows = (Integer) spinner.getValue();
        int valueSpinnerCols = (Integer) spinnerCols.getValue();
        frame.canvas.init(valueSpinnerRows,valueSpinnerCols);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
