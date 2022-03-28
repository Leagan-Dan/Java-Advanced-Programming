package commands;

import catalog.Catalog;
import items.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ViewCommand extends Command{
    /**
     * Opens the file of an item
     * @param catalog object of type Catalog
     * @param item object of type Item
     * @throws IOException exception for input/output
     */
    public void view(Catalog catalog, Item item) throws IOException {
        File file = new File(item.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        }catch (FileNotFoundException e){
            System.out.println("Couldn't open the file");
        }
    }
}
