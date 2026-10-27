import java.time.LocalTime;
import java.util.Scanner;

interface Alarm {
    void setAlarm(String time);

    void showAlarm();
}

abstract class Weekday implements Alarm {
}

public class Monday extends Weekday {
    private String time;

    public void setAlarm(String time) {
        this.time = time;
    }

    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(time);
        LocalTime now = LocalTime.now();

        if (alarm.isBefore(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else {
            System.out.println("I'll wake you up later!");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String time = input.nextLine();

        Monday m = new Monday();
        m.setAlarm(time);
        m.showAlarm();
    }
}