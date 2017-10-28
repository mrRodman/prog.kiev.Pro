import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Goods {

    public static void addGood(BufferedReader br) throws IOException, SQLException {
        try (PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO Goods (goods_name, price) " +
                     "VALUES (?, ?)")) {

            System.out.println("enter goods name");
            String name = br.readLine();
            System.out.println("Enter price");
            double price = Double.parseDouble(br.readLine());
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.executeUpdate();
        }
    }

    public static void getById(int id) throws SQLException {
        try (PreparedStatement ps = DB.getConnection().prepareStatement("SELECT *" +
                     "FROM Goods WHERE id = ?")){
            ps.setInt(1, id);

            DB.getData(ps);

        }
    }
}