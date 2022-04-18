package DAOcommands;

import java.sql.*;

public class CountryDAO {
    public void findById(int id, Connection connection) throws ClassNotFoundException, SQLException {

        PreparedStatement statement = connection.prepareStatement("select * from countries where id =?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getInt(3) + " " + resultSet.getString(4));
        }
    }

    public void findByName(String name, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from countries where name =?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getInt(3) + " " + resultSet.getString(4));
        }
    }
    public void insert(int id, String name, int code, String continent, Connection connection) throws SQLException {
        PreparedStatement statement= connection.prepareStatement("insert into countries values (?,?,?,?)");
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,code);
        statement.setString(4,continent);
        statement.executeQuery();

    }

}

