import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Orders {
    public static void addOrder(BufferedReader br) throws IOException, SQLException{
        try (PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO Orders" +
                     "(client_id, goods_id) VALUES (?, ?)")) {

            System.out.println("Enter client's id");
            int clId = Integer.parseInt(br.readLine());
            System.out.println("Enter good's id");
            int gId = Integer.parseInt(br.readLine());
            ps.setInt(1, clId);
            ps.setInt(2, gId);
            ps.executeUpdate();

        }
    }

    public static void getOrder(int id) throws SQLException {
        try (PreparedStatement ps = DB.getConnection().prepareStatement("SELECT *" +
                "FROM Orders WHERE id = ?")){
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){

                while (rs.next()) {
                    Clients.getById(Integer.parseInt(rs.getString(2)));
                    Goods.getById(Integer.parseInt(rs.getString(3)));
                }
            }
        }
    }
}
