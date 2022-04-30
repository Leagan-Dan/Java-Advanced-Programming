package DAOcommands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentDAO {
    public String findById(int id, Connection connection) throws ClassNotFoundException, SQLException {

        String result = null;
        PreparedStatement statement = connection.prepareStatement("select * from continents where id =?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            result="";
            int idResult = resultSet.getInt(1);
            String nameResult= resultSet.getString(2);
            result=result + idResult + " " + nameResult;
            System.out.println(result);
        }
        return result;
    }

    public void findByName(String name, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from continents where name =?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
        }
    }

    public void insert (int id, String name, Connection connection) throws SQLException {
        PreparedStatement statement= connection.prepareStatement("insert into continents values (?,?)");
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.executeQuery();

    }
}
