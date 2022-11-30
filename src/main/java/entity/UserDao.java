package entity;

import dao.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE columnName = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";


    public User create(User user) {
        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public User read(int userId) {
        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(SELECT_USER_QUERY.replace("columnName", "id"));
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setUserName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void update(User user) {
        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int userId) {
        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User[] findAll() {
        User[] allUsersArr = new User[0];
        try (Connection conn = DbUtil.connect()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM users");
            while (resultSet.next()) {
                User user = read(resultSet.getInt(1));
                allUsersArr = addToArray(user, allUsersArr);
            }
            return allUsersArr;
        } catch (SQLException e) {
            e.printStackTrace();
            return allUsersArr;
        }
    }


    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }


    // JAK POBRAĆ WARTOŚĆ KLUCZA GŁÓWNEGO WŁAŚNIE WPISANEGO DO BAZY DANYCH ELEMENTU:
//    PreparedStatement preStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//    ResultSet rs = preStmt.getGeneratedKeys();
//    if (rs.next()) {
//        long id = rs.getLong(1);
//        System.out.println("Inserted ID: " + id);
//    }

    // HASHOWANIE HASŁA:
//    public String hashPassword(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());

}


