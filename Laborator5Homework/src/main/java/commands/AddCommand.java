package commands;
import items.Item;
import catalog.Catalog;
public class AddCommand extends Command {
    public void add(Catalog catalog, Item item){
        catalog.add(item);
    }
}
