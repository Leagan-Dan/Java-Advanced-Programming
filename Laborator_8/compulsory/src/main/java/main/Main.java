package main;

import DAOcommands.ContinentDAO;
import DAOcommands.CountryDAO;
import database.Database;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Database dBConnection = new Database();

            Connection connection = dBConnection.getConnection();

            CountryDAO countryDAO=new CountryDAO();
            ContinentDAO continentDAO=new ContinentDAO();

            System.out.println("\nCOUNTRIES:");
            countryDAO.findById(2,connection);
            countryDAO.findByName("Romania" ,connection);
            countryDAO.insert(7,"Greece",106,"Europe",connection);
            countryDAO.findById(7,connection);

            System.out.println("\nCONTINENTS:");
            continentDAO.findById(1,connection);
            continentDAO.findByName("Asia",connection);
            continentDAO.insert(4,"America",connection);
            continentDAO.findById(4,connection);


            connection.close();
        }catch (Exception exception){
            System.out.println(exception);}
    }
}
