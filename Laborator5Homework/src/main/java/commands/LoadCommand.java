package commands;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadCommand extends Command{
    /**
     * Loads a .json file with another catalog
     * @param locatie the path to the .json file
     * @return an object of Catalog type
     * @throws IOException exception for input/output
     */
    public Catalog load(String locatie) throws IOException {
        Catalog catalog = new Catalog();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(locatie), Catalog.class);
            System.out.println("JSON loaded");
        } catch (FileNotFoundException e) {
            System.err.println("The file at the location " + locatie + " is missing!");
        }
        return catalog;
    }
}
