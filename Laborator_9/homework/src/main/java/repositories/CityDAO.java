package repositories;

import entities.City;
import entityManager.Manager;

import java.util.List;
import java.util.stream.IntStream;

public class CityDAO extends AbstractRepository<City>{

    public CityDAO() {
        super();
    }

    /**
     * Finds every row from a table
     * @return A list of cities
     */
    public List<City> findAll(){
        return Manager.getInstance().getManager().createNamedQuery("City.findAll",City.class).getResultList();
    }

    /**
     * Finds by name
     * @param name The name of the searched city
     * @return An object of type City
     */
    public City findByName(String name){
        return Manager.getInstance().getManager().createQuery("select a from City a where a.name='" + name + "'",
                City.class).getResultList().get(0);
    }

    /**
     * Adds multiple cities (300) into the cities table
     */
    public void addMultipleCities(){
        City[] cities = IntStream.rangeClosed(0, 300)
                .mapToObj(i -> new City("Romania", "Oras" + i, 0, (float) 1.5, (float) 2.0))
                .toArray(City[]::new);
        for (City cityIndex : cities)
            this.create(cityIndex);

    }
}