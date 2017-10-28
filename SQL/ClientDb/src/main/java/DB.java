import java.sql.*;

public class DB {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/orders";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "16403991";
    private static Connection connection;

    public DB() {
    }

    public static void init() throws SQLException{
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        try (Statement st = connection.createStatement()){
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("DROP TABLE IF EXISTS Orders");
            st.execute("DROP TABLE IF EXISTS Goods");

            st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "client_name VARCHAR (20), Email VARCHAR (25))");
            st.execute("CREATE TABLE Goods (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "goods_name VARCHAR (40), price DOUBLE)");
            st.execute("CREATE TABLE Orders (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "client_id INT, goods_id INT )");
        }
    }

    public static void getData(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()){
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1 ; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <=rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t");
                }
            }
            System.out.println();
        }
    }

    public static String getDbConnection() {
        return DB_CONNECTION;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DB.connection = connection;
    }
}
