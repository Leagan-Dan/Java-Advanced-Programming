package commandsDAO;

import drawMap.Coordinates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class CitiesDAO {
    /**
     * Finds all cities that have the specified id
     * @param id The id that is used for searching
     * @param connection The connection with the database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void findById(int id, Connection connection) throws ClassNotFoundException, SQLException {

        PreparedStatement statement = connection.prepareStatement("select * from cities where id =?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " + resultSet.getInt(4) + " " +
                    resultSet.getFloat(5) + " " + resultSet.getFloat(6));
        }
    }

    /**
     * Finds all cities that have the specified name
     * @param name The name that is used for searching
     * @param connection The connection with the database
     * @param name
     * @param connection
     * @throws SQLException
     */
    public void findByName(String name, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from cities where name =?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " + resultSet.getInt(4) + " " +
                    resultSet.getFloat(5) + " " + resultSet.getFloat(6));
        }
    }

    /**
     * Inserts a new city into the database
     * @throws SQLException
     */
    public void insert(int id, String country, String name, int capital, float latitude, float longitude, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into cities values (?,?,?,?,?,?)");
        statement.setInt(1, id);
        statement.setString(2, country);
        statement.setString(3, name);
        statement.setInt(4, capital);
        statement.setFloat(5, latitude);
        statement.setFloat(6, longitude);
        statement.executeQuery();

    }

    /**
     * Imports a CSV file using a scanner, and adds the data into the database
     * @param connection The connection with the database
     * @throws FileNotFoundException
     * @throws SQLException
     */
    public void importCSV(Connection connection) throws FileNotFoundException, SQLException {
        Scanner sc = new Scanner(new File("C:\\Users\\Dan\\Desktop\\concap.csv"));
        sc.useDelimiter(",");
        int count = 0;
        String country = null;
        String name = null;
        float latitude = 0;
        float longitude = 0;
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(input + " " + count);


            if (count == 0) {
                country = input;
            } else if (count == 1) {
                name = input;
            } else if (count == 2) {
                latitude = Float.parseFloat(input);
            } else if (count == 3) {
                longitude = Float.parseFloat(input);
            }

            count++;
            if (count == 5) {
                count = 0;
                PreparedStatement statement = connection.prepareStatement("insert into cities values (1,?,?,1,?,?)");
                statement.setString(1, country);
                statement.setString(2, name);
                statement.setFloat(3, latitude);
                statement.setFloat(4, longitude);
                statement.executeQuery();
            }
        }
        sc.close();
    }

    /**
     * Finds every city
     * @param connection The connection with the database
     * @throws SQLException
     */
    public void findAll(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from cities");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " + resultSet.getInt(4) + " " +
                    resultSet.getFloat(5) + " " + resultSet.getFloat(6));
        }
    }

    /**
     * Finds the distance between two cities that have the same names specified in parameters
     * @param city1 The name of the first city
     * @param city2 The name of the second city
     * @param connection The connection with the database
     * @return The distance in kilometers
     * @throws SQLException
     */
    public double distance(String city1, String city2, Connection connection) throws SQLException {

        double latitude1 = 0;
        double latitude2 = 0;
        double longitude1 = 0;
        double longitude2 = 0;

        PreparedStatement statement = connection.prepareStatement("select latitude, longitude from cities where name=?");
        statement.setString(1, city1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            latitude1 = resultSet.getFloat(1);
            longitude1 = resultSet.getFloat(2);
        }

        PreparedStatement statement2 = connection.prepareStatement("select latitude, longitude from cities where name=?");
        statement2.setString(1, city2);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next()) {
            latitude2 = resultSet2.getFloat(1);
            longitude2 = resultSet2.getFloat(2);
        }

        longitude1 = Math.toRadians(longitude1);
        longitude2 = Math.toRadians(longitude2);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        double dLongitude = longitude2 - longitude1;
        double dLatitude = latitude2 - latitude1;
        double a = Math.pow(Math.sin(dLatitude / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(dLongitude / 2), 2);

        double variable = 2 * Math.asin(Math.sqrt(a));

        double radius = 6371;

        System.out.print("The distance between " + city1 + " and " + city2 + ": ");

        return (variable * radius);
    }

    /**
     * Interogates the database in order to add the coordinates of all cities in the coordinates object
     * @param coordinates The object that stores the coordinates of all cities
     * @param connection The connection with the database
     * @throws SQLException
     */
    public void selectCoordinates(Coordinates coordinates, Connection connection) throws SQLException {

        float latitude = 0;
        float longitude = 0;

        PreparedStatement statement = connection.prepareStatement("select latitude, longitude from cities");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            latitude = resultSet.getFloat(1);
            longitude = resultSet.getFloat(2);
            coordinates.addCoordinates(longitude,latitude);
        }

    }
}
