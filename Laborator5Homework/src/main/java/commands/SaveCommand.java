package commands;

import items.*;
import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveCommand extends Command {
    /**
     * Saves the catalog object in a .json file
     * @param catalog object of type Catalog
     * @param locatie the path where the .json file will be saved
     * @throws IOException exception for input/output
     */
    public void save (Catalog catalog, String locatie) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(locatie), catalog);
        System.out.println("JSON saved");
    }

    /**
     * Saves every item as a new file
     * @param catalog object of type Catalog
     * @throws IOException exception for input/output
     */
    public void saveItems(Catalog catalog) throws IOException {
        List<Item> catalogList=new ArrayList<>();
        catalogList = catalog.getCatalog();
        for(Item item:catalogList){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(item.getLocation()), item);
            System.out.println(item.getName() + " saved");
        }
    }
}
