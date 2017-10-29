import javax.persistence.*;

@Entity
@NamedQueries( {
        @NamedQuery(name = "Menu.selectPrice", query = "select m from Menu m where m.price >= :lprice and m.price <= :hprice"),
        @NamedQuery(name = "Menu.selectDiscount", query = "select m from Menu m where discount <> 0.0"),
        @NamedQuery(name = "Menu.selectWeight", query = "select m from Menu m where m.name = :name")
})
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    private double price;
    private double weight;
    private double discount;

    public Menu() {
    }

    public Menu(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Menu{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", weight=").append(weight);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}