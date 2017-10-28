import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartment";
    private static final String DB_USER = "root";
    static final String DB_PASSWORD = "";
    private static Connection connection;


    public static void main(String[] args) {


        try (Scanner sc = new Scanner(System.in)){
            try {
                connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                initDB();

                while (true) {
                    System.out.println("1 - add apartment");
                    System.out.println("2 - select by region");
                    System.out.println("3 - select by price");
                    System.out.println("4 - select by area");
                    System.out.println("5 - select by number of rooms");
                    System.out.println("6 - delete apartment");

                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            addApartment(sc);
                            break;
                        case "2":
                            selectByRegion(sc);
                            break;
                        case "3":
                            selectByPrice(sc);
                            break;
                        case "4":
                            selectByArea(sc);
                            break;
                        case "5":
                            selectByRoomNumber(sc);
                            break;
                        case "6":
                            deleteApartment(sc);
                            break;
                        default:
                            break; //return and everything falls
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initDB() throws SQLException {
        try (Statement st = connection.createStatement()){
            st.execute("DROP TABLE IF EXISTS Apartments");
            st.execute("CREATE TABLE Apartments(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "region VARCHAR(20), area INT, roomNumber INT, price DOUBLE)");
        }
    }

    private static void addApartment(Scanner sc) throws SQLException {
        System.out.println("Enter region of your apartment");
        String region = sc.nextLine();
        System.out.println("Enter area");
        int area = sc.nextInt();
        System.out.println("Enter rooms number");
        int roomNumber = sc.nextInt();
        System.out.println("Enter price");
        double price = sc.nextDouble();

        try (PreparedStatement pst =
                     connection.prepareStatement("INSERT INTO Apartments(region, area, roomNumber, price) " +
                             "VALUES (?, ?, ?, ?)")) {

            pst.setString(1, region);
            pst.setInt(2, area);
            pst.setInt(3, roomNumber);
            pst.setDouble(4, price);
            pst.executeUpdate();

        }
    }

    private static void selectByRegion(Scanner sc) throws SQLException{
        System.out.println("Enter region to search");
        String region = sc.nextLine();

        try (PreparedStatement pst = connection.prepareStatement("SELECT *" +
                "FROM Apartments WHERE region = ?")) {

            pst.setString(1, region);
            getData(pst);
            System.out.println();
        }
    }
    private static void selectByPrice(Scanner sc) throws SQLException {
        System.out.println("Enter your min price");
        int minPrice = sc.nextInt();
        System.out.println("Enter your max price");
        int maxPrice = sc.nextInt();

        if (minPrice > maxPrice) {
            System.out.println("Wrong interval");
        }

        try (PreparedStatement ps = connection.prepareStatement("SELECT *" +
                "FROM Apartments WHERE price >= ? AND price <= ?")) {

            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);

            getData(ps);
            System.out.println();
        }
    }

    private static void selectByArea (Scanner sc) throws SQLException {
        System.out.println("Enter max area");
        int area = sc.nextInt();

        try (PreparedStatement ps = connection.prepareStatement("SELECT *" +
                "FROM Apartments WHERE area <= ?")){

            ps.setInt(1, area);

            getData(ps);
        }
    }

    private static void selectByRoomNumber(Scanner sc) throws SQLException {
        System.out.println("Enter room number");
        int rooms = sc.nextInt();

        try (PreparedStatement ps = connection.prepareStatement("select * " +
                "from Apartments WHERE roomNumber = ?;")){
            ps.setInt(1, rooms);

            getData(ps);
        }
    }

    private static void getData(PreparedStatement pst) throws SQLException{
        try (ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData rsm = rs.getMetaData();
            for (int i = 1; i <= rsm.getColumnCount(); i++)
                System.out.print(rsm.getColumnName(i) + "\t\t");
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t");
                }
                System.out.println();
            }
        }
    }

    private static void deleteApartment(Scanner sc) throws SQLException {
        System.out.println("enter id of apartment to delete");
        int id = sc.nextInt();
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Apartments WHERE id = ?")){
            pst.setInt(1, id);
        }
    }
}
