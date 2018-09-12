import java.sql.*;
import java.util.HashMap;

class SystemLogin {
    public static void checkDataBAse(String url, String login, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean condition = false;
        while (!condition) {
            try (Connection connection = DriverManager.getConnection(url, login, password);
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("USE Users;");
                condition = true;
            } catch (SQLException e) {
                if (e.getMessage().equals("Unknown database 'users'")) {
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", login, password);
                         Statement statement = connection.createStatement()) {
                        statement.executeUpdate("CREATE DATABASE Users");
                        statement.executeUpdate("USE Users;");
                        statement.executeUpdate("CREATE TABLE  users_table (id INT AUTO_INCREMENT PRIMARY KEY ," +
                                "NAME  VARCHAR (255) NOT NULL," +
                                "password VARCHAR (255) NOT NULL," +
                                "health INT," +
                                "damage INT, rating INT)");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public static User signingIn(User userToCheck, String url, String login, String password) {
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", login, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("USE Users;");
            resultSet = statement.executeQuery("SELECT * FROM users_table;");
            HashMap<String, User> usersMap = new HashMap<>();
            User u = null;
            while (resultSet.next()) {
                u = new User(resultSet.getString("NAME"), resultSet.getString("password"),
                        resultSet.getInt("health"), resultSet.getInt("damage"),
                        resultSet.getInt("rating"));
                usersMap.put(u.getName(), u);
            }
            if (usersMap.containsKey(userToCheck.getName())) {// Случай когда совпало имя
                User user1 = usersMap.remove(userToCheck.getName());
                if (user1.getPassword().equals(userToCheck.getPassword())) {
                    System.out.println("Есть такой в базе данных");
                    //Если игрок с таким именем и паролем есть, то игрока авторизует;
                    //return true;
                    return user1;
                } else {
                    System.out.println("Пароль введён не верно");
                    //Если игрок есть, но пароль не совпал – выдать ошибку.
                    //return false;
                    return null;
                }
            } else {
                //Если игрока нет, то он создается с параметрами урон 10, жизни 100;
                System.out.println("Нет такого => вставляем");
                statement.executeUpdate("INSERT INTO users_table (NAME, password, health, damage, rating)" +
                        " VALUES ('" + userToCheck.getName() + "','" + userToCheck.getPassword() + "','" + userToCheck.getHealth() +
                        "','" + userToCheck.getDamage() + "','" + userToCheck.getRating() + "');");
                //return true;
                return new User(userToCheck.getName(), userToCheck.getPassword(), userToCheck.getHealth(), userToCheck.getDamage(), userToCheck.getRating());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //return false;
            return null;
        }
    }
}
