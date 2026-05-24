import java.time.*;
import java.time.format.DateTimeFormatter;

public class Lesson28DateAndTime {
    public static void run() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current datetime: " + currentDateTime);
        Instant currentInstant = Instant.now();
        System.out.println("Current instant: " + currentInstant);

        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formatted time: " + dtFormatter.format(currentDateTime));

        LocalDate invoiceDate = LocalDate.of(2026, 5, 24);
        System.out.println("Invoice date: " + invoiceDate);
        LocalDateTime deadline = LocalDateTime.of(2026, 8, 30, 12, 30);
        System.out.println("Deadline date: " + deadline);

        if (currentDateTime.isBefore(deadline)) {
            Duration duration = Duration.between(currentDateTime, deadline);
            System.out.println("Remaining days to deadline: " + duration.toDays());
        }
    }
}
