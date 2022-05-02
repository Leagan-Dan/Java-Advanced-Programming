package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CountryDAO countryDAO = new CountryDAO();
        System.out.println(countryDAO.findByName("Greece"));
        System.out.println(countryDAO.findById(5));
        Country country=new Country("Belgium",25,"Europe");
        //countryDAO.create(country);
        System.out.println(countryDAO.findByName("Belgium"));
        System.out.println(countryDAO.findAll());
    }
}
