package task2;

import java.util.Arrays;

public class JSON {
    private String name;
    private String surname;
    private String[] phones;
    private String[] sites;
    private Address address;

    public JSON() {
    }

    @Override
    public String toString() {
        return "JSON{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", sites=" + Arrays.toString(sites) +
                ",\naddress=" + address +
                '}';
    }
}
