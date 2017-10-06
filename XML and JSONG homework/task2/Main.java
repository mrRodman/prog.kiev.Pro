package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:/Java/Pro/xmlLesson/src/task2/1.txt");
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while (br.ready()) {
                result.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result.toString(), JSON.class);

        System.out.println(json);

    }
}
