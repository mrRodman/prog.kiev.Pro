package task3;

public class Main {
    public static void main (String[] args) {
        char[] chars = new char[] {'a', 's', 'd'};
        double[] doubles = new double[] {1.0, 1.5, 4.5};
        Container container1 = new Container(1, 2, "some text", chars, doubles);
        Container container2 = new Container();

        SaveLoad.save(container1);
        SaveLoad.load(container2);

        System.out.println(container2);
    }
}
