package ge.tbc.tbcitacademy.util;

import ge.tbc.tbcitacademy.data.Constants;
import ge.tbc.tbcitacademy.data.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TableParser {
    public String getUsernameById(String id) {
        String username = null;
        String SQL = "select username from Users where id = ?";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    username = resultSet.getString(Constants.USERNAME);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }

    public String getPassword() {
        String password = null;
        String SQL = "select password from Users where username = 'standard_user'";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                password = resultSet.getString(Constants.PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}
