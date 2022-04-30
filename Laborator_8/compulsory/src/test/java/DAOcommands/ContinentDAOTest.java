package DAOcommands;

import database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class ContinentDAOTest {

    ContinentDAO continentDAO=new ContinentDAO();
    String result = "";
    Database database=new Database();
    Connection connection=database.getConnection();

    public ContinentDAOTest() throws ClassNotFoundException {
    }

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        result=continentDAO.findById(4,connection);
    }
    @Test
    public void testFindById(){
        Assert.assertEquals("4 America",result);
    }
}