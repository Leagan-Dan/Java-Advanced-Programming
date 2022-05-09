package repositories;

import entities.Continent;
import entityManager.Manager;

import java.util.List;

public class ContinentDAO extends AbstractRepository<Continent>{


    public ContinentDAO(){
        super();
    }

    /**
     * Find every row from a table
     * @return A list of continents
     */
    public List<Continent> findAll(){
        return Manager.getInstance().getManager().
                createNamedQuery("Continent.findAll",Continent.class).getResultList();
    }

    /**
     * Finds by name
     * @param name The name of the searched continent
     * @return An object of type Continent
     */
    public Continent findByName(String name){
        return Manager.getInstance().getManager().createQuery("select a from Continent a where a.name='" + name + "'",
                Continent.class).getResultList().get(0);
    }

}
