package catalog;
import items.Item;
import java.util.ArrayList;
import java.util.List;

public class Catalog{
    private List<Item> catalog = new ArrayList<>();

    public Catalog() {

    }

    public void add(Item item){
        for(int index=0;index<catalog.size();index++){
            if(catalog.get(index).getId()==item.getId()){
                throw new MyException(item.getId());
            }
        }

        catalog.add(item);
    }

    public List getCatalog() {
        return catalog;
    }

    public void setCatalog(List catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalog=" + catalog +
                '}';
    }
}
