package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataProvider {
    @DataProvider
    public static Object[][] getUserData() {

        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = """
                    SELECT * FROM Users4
                    WHERE Username = ? OR Username = ?
                    """;
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, "standard_user");
            preparedStatement.setString(2, "locked_out_user");

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            int rowCount = resultSet.getRow(); // getting row count
            resultSet.beforeFirst();
            Object[][] data = new Object[rowCount][resultSet.getMetaData().getColumnCount()];

            int iter = 0;
            while (resultSet.next()) {
                data[iter] = new Object[]{
                        resultSet.getString("Username"),
                        resultSet.getString("PASSWORDHASH")
                };
                iter++;
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
