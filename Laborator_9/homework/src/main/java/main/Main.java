package main;

import java.sql.SQLException;

import entities.City;
import entities.Continent;
import entities.Country;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import repositories.CityDAO;
import repositories.ContinentDAO;
import repositories.CountryDAO;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String log4jConfPath = "src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        ContinentDAO continentDAO=new ContinentDAO();
        Continent continent= new Continent("America2");
        continentDAO.create(continent);
        System.out.println(continentDAO.findAll());
        System.out.println(continentDAO.findByName("America2"));


        CountryDAO countryDAO = new CountryDAO();
        Country country=new Country("Belgium",25,"Europe");
        countryDAO.create(country);
        System.out.println(countryDAO.findByName("Belgium"));
        System.out.println(countryDAO.findAll());



        CityDAO cityDAO=new CityDAO();
        City city=new City("Romania","Brasov",0, (float) 1.3,(float) 1.5);
        cityDAO.create(city);
        System.out.println(cityDAO.findAll());
        System.out.println(cityDAO.findByName("Bucuresti"));
        //cityDAO.addMultipleCities();

    }
}
