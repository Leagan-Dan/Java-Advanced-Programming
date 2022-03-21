package Catalog;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CatalogUtil {
    /**
     * Saves the catalog as a JSON in the specified location
     * @param catalog object that will be saved
     * @param locatie path where the object will be saved
     * @throws IOException
     */
    public void save (Catalog catalog, String locatie) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(locatie), catalog);
        System.out.println("JSON saved");
    }

    /**
     * Loads a catalog from the specified location
     * @param locatie the path from where the catalog will be loaded
     * @return object of type Catalog
     * @throws IOException
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
