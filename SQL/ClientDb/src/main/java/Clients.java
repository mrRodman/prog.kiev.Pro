import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clients {

    public static void addClient(BufferedReader br) throws IOException, SQLException {
        try (PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO Clients(client_name, eMail)" +
                     "VALUES (?, ?)")){

            System.out.println("enter name of client");
            String name = br.readLine();
            System.out.println("Enter e-mail");
            String eMail = br.readLine();
            ps.setString(1, name);
            ps.setString(2, eMail);
            ps.executeUpdate();

        }
    }

    public static void getById(int id) throws SQLException {
        try (PreparedStatement ps = DB.getConnection().prepareStatement("SELECT *" +
                "FROM Clients WHERE id = ?")){

            ps.setInt(1, id);
            DB.getData(ps);
        }
    }

}
