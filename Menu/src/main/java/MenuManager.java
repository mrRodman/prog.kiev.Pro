import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class MenuManager {

    public MenuManager() {
    }

    public static void addDish(BufferedReader br, EntityManager em) throws IOException {
        try {
            em.getTransaction().begin();

            System.out.println("Type name");
            String name = br.readLine();

            System.out.println("Type price");
            int price = Integer.parseInt(br.readLine());

            System.out.println("Type weight");
            int weight = Integer.parseInt(br.readLine());

            System.out.println("discount? (y/n)");
            String discount = br.readLine();

            Menu menu = new Menu(name, price, weight);
            if (discount.equals("y")){
                System.out.println("Type discount");
                double discont = Double.parseDouble(br.readLine());
                menu.setDiscount(discont);
            }
            em.persist(menu);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static void addDefaultDishes(EntityManager em) {
        try {
            em.getTransaction().begin();
            Menu[] menus = new Menu[30];
            for (int i = 0; i < menus.length; i++) {
                menus[i] = new Menu("Dish" + i, 30 * i, 50 * i);
                if (i % 4 == 0)
                    menus[i].setDiscount(i * 0.01);
            }

            for (Menu m : menus) {
                em.persist(m);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static void selectByPrice(BufferedReader br, EntityManager em) throws IOException {
        System.out.println("Type low price");
        int lprice = Integer.parseInt(br.readLine());
        System.out.println("Type high price");
        int hprice = Integer.parseInt(br.readLine());

        Query query = em.createNamedQuery("Menu.selectPrice", Menu.class);
        query.setParameter("lprice", lprice * 1.0);
        query.setParameter("hprice", hprice * 1.0);

        List<Menu> dishes = query.getResultList();
        for (Menu m : dishes) {
            System.out.println(m.getName() + " - " + m.getPrice() + " - " + m.getWeight() + " - " + m.getDiscount());
        }
    }

    public static void selectByWeight(BufferedReader br, EntityManager em) throws IOException {
        System.out.println("Enter your dishes with weight to 1 kg");
        System.out.println("Type 'exit' to finish");
        System.out.println("Type 'cl' to clear list");
        while (true) {
            System.out.print("Dish: ");
            String name = br.readLine();
            if (name.equals("exit"))
                break;

            if (name.equals("cl")) {
                Dishes.clearDishes();
                continue;
            }

            Query query = em.createNamedQuery("Menu.selectWeight", Menu.class);
            query.setParameter("name", name);

            if (query.getResultList().isEmpty())
                return;

            Menu dish = (Menu) query.getSingleResult();
            Dishes.addDish(dish);
        }
        System.out.println(Dishes.getDishes().toString());
        Dishes.clearDishes();
    }

    public static void selectByDiscount(EntityManager em) {
        Query query = em.createNamedQuery("Menu.selectDiscount", Menu.class);
        List<Menu> dishes = query.getResultList();

        for (Menu m : dishes) {
            System.out.println(m.getName() + ":");
            System.out.println("price without discount: " + m.getPrice());
            System.out.println("discount: " + m.getDiscount() * 100 + "%");
        }
        System.out.println();
    }
}