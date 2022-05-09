package repositories;

import entities.Country;
import entityManager.Manager;

import java.util.List;

public class CountryDAO extends AbstractRepository<Country>{

    public CountryDAO(){
        super();
    }

    /**
     * Finds by name
     * @param name The name of the searched country
     * @return An object of type Country
     */
    public Country findByName(String name) {

        try {
            return Manager.getInstance().getManager().createQuery("select a from Country a where a.name='" + name + "'", Country.class).getResultList().get(0);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Finds by id
     * @param id The id of the searched country
     * @return An object of type Country
     */
    public Country findById(int id){
        try {
            return Manager.getInstance().getManager().find(Country.class, id);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Finds every row from a table
     * @return A list of countries
     */
    public List<Country> findAll(){
        try {
            return Manager.getInstance().getManager().createNamedQuery("Country.findAll", Country.class).getResultList();
        } catch (Exception e){
            return null;
        }
    }

}

