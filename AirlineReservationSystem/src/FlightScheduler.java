import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

public class FlightScheduler {
    public LocalDateTime scheduleFlight(int daysFromNow) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysFromNow);
        calendar.add(Calendar.HOUR, new Random().nextInt(24)); // Randomize the hour
        calendar.set(Calendar.MINUTE, (calendar.get(Calendar.MINUTE) * 3) - new Random().nextInt(45));

        return LocalDateTime.ofInstant(calendar.toInstant(), java.time.ZoneId.systemDefault());
    }
}
