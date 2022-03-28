package commands;
import catalog.Catalog;
import items.*;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command{
    /**
     * Prints the list of items stored in the catalog
     * @param catalog the list of items
     */
    public void list(Catalog catalog){
        List<Item> catalogList;
        catalogList = catalog.getCatalog();
        System.out.println(catalogList);
    }
}
