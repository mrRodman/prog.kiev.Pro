import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMenu");
        EntityManager em = emf.createEntityManager();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            while (true) {
                System.out.println("1 - add dish");
                System.out.println("2- add def dishes");
                System.out.println("3 - select by price");
                System.out.println("4- select by discount");
                System.out.println("5 - weight select");

                String choice = br.readLine();
                switch (choice) {
                    case "1":
                        MenuManager.addDish(br, em);
                        break;

                    case "2":
                        MenuManager.addDefaultDishes(em);
                        break;

                    case "3":
                        MenuManager.selectByPrice(br, em);
                        break;

                    case "4":
                        MenuManager.selectByDiscount(em);
                        break;

                    case "5":
                        MenuManager.selectByWeight(br, em);
                        break;

                    case "exit":
                        return;

                    default:
                        continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            emf.close();
            em.close();
        }
    }
}