package task3;

import java.io.*;

public class SaveLoad {

    public SaveLoad() {
    }

    public static void save(Container container) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/1.txt"))){
            container.writeExternal(oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(Container container) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/1.txt"))){
            container.readExternal(ois);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
