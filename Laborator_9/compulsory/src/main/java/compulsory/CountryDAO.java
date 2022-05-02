package compulsory;

import java.util.List;

public class CountryDAO {
    public Country findByName(String name) {

        try {
            return Manager.getInstance().getManager().createQuery("select a from Country a where a.name='" + name + "'", Country.class).getResultList().get(0);
        } catch (Exception e){
            return null;
        }
    }

    public Country findById(int id){
        try {
            return Manager.getInstance().getManager().find(Country.class, id);
        }catch (Exception e){
            return null;
        }
    }

    public void create(Country country){
        Manager.getInstance().getManager().persist(country);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public List<Country> findAll(){
        try {
            return Manager.getInstance().getManager().createNamedQuery("Country.findAll", Country.class).getResultList();
        } catch (Exception e){
            return null;
        }
    }

}

