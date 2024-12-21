package ge.tbc.testautomation.data;

import java.sql.*;
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

    public UserModel getSpecificUser() {
        UserModel user = new UserModel();
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = """
                    SELECT RegistrationData.id, firstName, lastName, Accounts.username
                    FROM RegistrationData
                    INNER JOIN Accounts ON RegistrationData.id = Accounts.ownerId
                    """;
            Statement statement
                    = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
//                user = new UserModel(
//                        resultSet.getInt("RegistrationData.id"),
//                        resultSet.getString("firstName"),
//                        resultSet.getString("lastName"),
//                        resultSet.getString("username")
//                );
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUsername(resultSet.getString("username"));
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
