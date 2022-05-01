package main;

import commandsDAO.CitiesDAO;
import commandsDAO.ContinentDAO;
import commandsDAO.CountryDAO;
import drawMap.*;
import singleton.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {

            Database dBConnection = new Database();
            Connection connection = dBConnection.getConnection();

            CountryDAO countryDAO=new CountryDAO();
            ContinentDAO continentDAO=new ContinentDAO();
            CitiesDAO citiesDAO=new CitiesDAO();

            System.out.println("\nCOUNTRIES:");
            countryDAO.findById(2,connection);
            countryDAO.findByName("Romania" ,connection);
            /*countryDAO.insert(5,"Hungary",105,"Europe",connection);*/
            countryDAO.findById(5,connection);

            System.out.println("\nCONTINENTS:");
            continentDAO.findById(1,connection);
            continentDAO.findByName("Asia",connection);
            /*continentDAO.insert(3,"America",connection);*/
            continentDAO.findById(3,connection);

            System.out.println("CITIES");
            citiesDAO.findById(1,connection);
            citiesDAO.findByName("Bucuresti",connection);
            //citiesDAO.insert(2,"Romania","Bucuresti",1, (float) 2.1, (float) 3.2, connection);
            //citiesDAO.importCSV(connection);
            citiesDAO.findAll(connection);
            System.out.println(citiesDAO.distance("Singapore", "Amsterdam", connection) + " kilometers");


            Coordinates coordinates=new Coordinates();
            citiesDAO.selectCoordinates(coordinates,connection);

            new MainFrame(coordinates).setVisible(true);
            connection.close();
        }catch (Exception exception){
            System.out.println(exception);}
    }
}
