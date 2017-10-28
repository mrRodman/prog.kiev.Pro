import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            DB.init();
            while (true) {
                System.out.println("1 - add client");
                System.out.println("2 - add goods");
                System.out.println("3 - get client by id");
                System.out.println("4 - get goods by id");
                System.out.println("5 - add order");
                System.out.println("6 - get order by id");
                System.out.println();

                String choice = br.readLine();

                switch (choice) {
                    case "1": Clients.addClient(br);
                    break;

                    case "2": Goods.addGood(br);
                    break;

                    case "3": Clients.getById(Integer.parseInt(br.readLine()));
                    break;

                    case "4": Goods.getById(Integer.parseInt(br.readLine()));
                    break;

                    case "5": Orders.addOrder(br);
                    break;

                    case "6": Orders.getOrder(Integer.parseInt(br.readLine()));
                    break;

                    case "exit": return;

                    default:
                        System.out.println("No such command");
                        break;
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
