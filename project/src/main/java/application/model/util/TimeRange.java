package application.model.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRange {
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String formattedStart;
    private final String formattedEnd;

    public TimeRange(LocalDateTime start, LocalDateTime end) throws InvalidLocalDateTimeException, InvalidChronologicalOrderException {
        if(isInvalidDate(start)) throw new InvalidLocalDateTimeException(start + "was an invalid date");
        if(isInvalidDate(end)) throw new InvalidLocalDateTimeException(end + "was an invalid date");
        if(isNotChronological(start, end)) throw new InvalidChronologicalOrderException("invalid order");

        this.start = start;
        this.end = end;

        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedStart = start.format(formatDateTime);
        formattedEnd = end.format(formatDateTime);
    }

    public String getFormattedStart(){return formattedStart;}
    public String getFormattedEnd(){return formattedEnd;}
    public LocalDateTime getStart(){return start;}
    public LocalDateTime getEnd(){return end;}

    private boolean isNotChronological(LocalDateTime startDate, LocalDateTime endDate){
        return startDate.isAfter(endDate);
    }

    private boolean isInvalidDate(LocalDateTime date){
        if(date == null) return true;
        LocalDateTime now = LocalDateTime.now().minusHours(1); // Give a buffer one hour before a date is invalid
        return date.isBefore(now);
    }

    public boolean isInRange(LocalDateTime date) {
        return date.isAfter(start) && date.isBefore(end);
    }
}