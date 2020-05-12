import java.io.File;
import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt; public static Statement getStmt(){return stmt;}
    public final static String DB_NAME_PATH ="main.db";
    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+ DB_NAME_PATH);
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteProductById(int id) throws SQLException {
        PreparedStatement prepStmt = connection.prepareStatement("DELETE FROM main WHERE id = ?");

        prepStmt.setInt(1,id);

        prepStmt.executeUpdate();
    }
    public static void addProduct(String name, String color, int amount, int price) throws SQLException {
        //PreparedStatement example: https://stackoverflow.com/a/3613194
        PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO main (name,color,amount,price) VALUES (?,?,?,?)");

        prepStmt.setString(1,name);
        prepStmt.setString(2,color);
        prepStmt.setInt(3,amount);
        prepStmt.setInt(4,price);

        prepStmt.executeUpdate();
    }
    public static void updateProductAmount(int id, int amount) throws SQLException {
        //PreparedStatement example: https://stackoverflow.com/a/3613194
        PreparedStatement prepStmt = connection.prepareStatement("UPDATE main SET amount = ? WHERE id = ?");
        prepStmt.setInt(1,amount);
        prepStmt.setInt(2,id);

        prepStmt.executeUpdate();
    }
    public static ResultSet getDbData() throws SQLException {
        return stmt.executeQuery("SELECT * FROM main");
    }
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//INSERT INTO 'main' ('login', 'password', 'nickname', 'age') VALUES ('bob', '123', 'xXBoBXx', 5);
//CREATE TABLE 'main' (
//  'login' varchar(40) NOT NULL,
//  'password' varchar(40) NOT NULL,
//  'nickname' varchar(40) NOT NULL,
//  'age' int(40) NOT NULL
//) ENGINE=MyISAM DEFAULT CHARSET=latin1;

    /*public static String getPriceByProductColor(String name, String color) {
        try {
            ResultSet rs = stmt.executeQuery(
                    "SELECT price FROM main WHERE name = '" + name +"' AND color = '" + color + "'"
            );
            if (rs.next()) {
                return rs.getString("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }*/