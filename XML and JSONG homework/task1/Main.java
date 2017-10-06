package task1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("E:/Java/Pro/xmlLesson/src/task1/1.xml");
        File file2 = new File("E:/Java/Pro/xmlLesson/src/task1/2.xml");

        Trains trains = new Trains();
        trains.add(new Train(1, "qwe", "asd", "12.03.18", "19:45"));
        trains.add(new Train(2, "poi", "lkj", "06.10.18", "15:55"));
        trains.add(new Train(3, "zxc", "mnb", "12.12.17", "19:20"));

        XMLWork.createXML(file2, trains);

        Trains trains1 = XMLWork.getFromXML(file2);

        for (Train train : trains1.getTrains()) {
            TrainCheck.check(train);
        }

    }
}