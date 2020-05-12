import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            AuthService.connect();

            logDb();

            AuthService.addProduct("Cool Shirt","Green",6,120);
            logDb();

            AuthService.deleteProductById(1);
            logDb();

            AuthService.updateProductAmount(2,5);
            logDb();

            AuthService.disconnect();
        }catch (SQLException e){e.printStackTrace();}
    }
    public static void logDb() throws SQLException {
        System.out.println(resultSetToString(AuthService.getDbData()));;
    }
    public static String resultSetToString(ResultSet rs) throws SQLException {
        int numberColumns = 4;
        List<String> rows = new ArrayList();
        while(rs.next()){
            String[] row = new String[numberColumns];
            for(int i = 1;i<=numberColumns;i++){
                row[i-1]=rs.getString(i);
            }
            rows.add(String.join(", ", row));
        }
        return rows.toString();
    }
}
