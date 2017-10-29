import java.util.ArrayList;

public class Dishes {
    private static ArrayList<Menu> dishes = new ArrayList<>();

    public Dishes() {
    }

    public static void addDish(Menu dish) {
        double weight = 0;
        if (dish == null)
            return;

        for (Menu m : dishes) {
            weight += m.getWeight();
        }

        weight += dish.getWeight();

        if (weight <= 1000)
            dishes.add(dish);
        else
            System.out.println("It's more that 1 kg");
    }

    public static void clearDishes() {
        dishes.clear();
    }

    public static ArrayList<Menu> getDishes() {
        return dishes;
    }
}