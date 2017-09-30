package task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "e:/1.txt")
public class TextContainer {

    public TextContainer() {
    }

    private String text = "Some text to save";

    @Saver
    public void save(String p) {

        File file = new File(p);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void notSave() {
        System.out.println("NOT SAVE");
    }
}
