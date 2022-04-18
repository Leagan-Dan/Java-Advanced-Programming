package main;

import DAOcommands.ContinentDAO;
import DAOcommands.CountryDAO;
import database.Database;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Database dBConnection = new Database();
            dBConnection.createConnection();
            Connection connection = dBConnection.getConnection();

            CountryDAO countryDAO=new CountryDAO();
            ContinentDAO continentDAO=new ContinentDAO();

            System.out.println("\nCOUNTRIES:");
            countryDAO.findById(2,connection);
            countryDAO.findByName("Romania" ,connection);
            countryDAO.insert(6,"Greece",106,"Europe",connection);
            countryDAO.findById(6,connection);

            System.out.println("\nCONTINENTS:");
            continentDAO.findById(1,connection);
            continentDAO.findByName("Asia",connection);
            continentDAO.insert(3,"America",connection);
            continentDAO.findById(3,connection);


            connection.close();
        }catch (Exception exception){
            System.out.println(exception);}
    }
}
