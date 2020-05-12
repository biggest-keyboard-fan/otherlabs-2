import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) {
        File dbFile = new File(AuthService.DB_NAME_PATH);
        if(dbFile.exists())dbFile.delete();
        AuthService.connect();
        initBd();
    }
    public static void initBd() {
        Statement stmt = AuthService.getStmt();
        try {
            stmt.execute(
                    "CREATE TABLE 'main' (\n" +
                            "  'id' INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "  'name' varchar(12) NOT NULL,\n" +
                            "  'color' varchar(12) NOT NULL,\n" +
                            "  'amount' int(8) NOT NULL,\n" +
                            "  'price' int(8) NOT NULL\n" +
                            ");");
            stmt.execute("INSERT INTO 'main' ('name', 'color', 'amount', 'price') VALUES ('shirt', 'red', 5, 100);");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static boolean deleteDbFileIfExists() {
        File dbFile = new File(AuthService.DB_NAME_PATH);
        System.out.println("Exists: " + dbFile.exists());
        if (!dbFile.exists()) return false;
        return dbFile.delete();
    }
}
