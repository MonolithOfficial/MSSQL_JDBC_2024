package ge.tbc.testautomation.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseSteps {
    public HashMap<String, String> getAllUsernamesAndPasswords() {
        HashMap<String, String> users = new HashMap<>();
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = "SELECT * FROM Users4";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                users.put(resultSet.getString("Username"), resultSet.getString("PASSWORDHASH"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
