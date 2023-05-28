package org.example.repository;
import org.example.model.User;
import org.example.config.DataBaseConnection;
import java.sql.*;
public class userRepo {

    private static final String INSERT_QUERY = "insert into find(username,password ,nationalode) values (?,?,?)";
    private static final String SELECT_BY_NATIONAL_CODE_QUERY = "select * from find where nationalode=?";
    private static final String SELECT_QUERY = "select * from find where (nationalode = ? and password=?)";
    private static final String UPDATE_PASSWORD_QUERY = "update find set password = ? where id = ?";

    public static void createUser(User user) {
        try {
            Connection connection = DataBaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNationalCode());


            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static User findUser(String user) {
        try {
            Connection connection = DataBaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NATIONAL_CODE_QUERY);
            preparedStatement.setString(1, user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String nationalCode = resultSet.getString(4);
                return new User(username,nationalCode, password);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static User findUser1(String nationalCode,String password) {
        try {
            Connection connection = DataBaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, nationalCode);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationCode2 = resultSet.getString(4);
                String password1 = resultSet.getString(3);
                return new User(username,nationCode2, password);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void updateUserPassword(User user,String newPassword){
        try {
            Connection connection = DataBaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_QUERY);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, user.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
