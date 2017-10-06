package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrainCheck {

    public TrainCheck() {
    }

    private static boolean timeCheck(Train train) {
        if (train == null && train.getDeparture() == null) {
            System.err.println("null");
            return false;
        }

        String[] text = train.getDeparture().split(":");
        int hours = Integer.parseInt(text[0]);

        if (hours >=15 && hours <=19)
            return true;

        return false;
    }

    public static void check(Train train) {
        if (train == null && train.getDeparture() == null) {
            System.err.println("null");
            return;
        }
        String[] text = train.getDate().split("\\.");
        int day = Integer.parseInt(text[0]);

        Calendar calendar = Calendar.getInstance();

        if (day == calendar.get(Calendar.DAY_OF_MONTH) && timeCheck(train))
            System.out.println(train);
    }
}
