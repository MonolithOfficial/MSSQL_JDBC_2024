package ge.tbc.testautomation;

import ge.tbc.testautomation.data.DatabaseSteps;
import ge.tbc.testautomation.data.MSSQLConnection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SauceDemoTest {
    DatabaseSteps databaseSteps;

    @BeforeClass
    public void setUp() {
        databaseSteps = new DatabaseSteps();
    }

    @Test
    public void testDb() {
        HashMap<String, String> users = databaseSteps.getAllUsernamesAndPasswords();
        System.out.println(users);
    }
}
