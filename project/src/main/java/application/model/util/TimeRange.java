package application.model.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRange {
    private LocalDateTime start;
    private LocalDateTime end;
    private DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String formattedStart = start.format(formatDateTime);
    private String formattedEnd = end.format(formatDateTime);

    public TimeRange(LocalDateTime start, LocalDateTime end) throws InvalidLocalDateTimeException, InvalidChronologicalOrderException {
        if(!isValidDate(start)) throw new InvalidLocalDateTimeException(start + "was an invalid date");
        if(!isValidDate(end)) throw new InvalidLocalDateTimeException(end + "was an invalid date");
        if(!isChronological(start, end)) throw new InvalidChronologicalOrderException("invalid order");
        this.start = start;
        this.end = end;
    }

    public String getStringStart(){return formattedStart;}
    public String getStringEnd(){return formattedEnd;}
    public LocalDateTime getStart(){return start;}
    public LocalDateTime getEnd(){return end;}

    private boolean isChronological(LocalDateTime startdate, LocalDateTime enddate){
        return true;
    }

    private boolean isValidDate (LocalDateTime date){
        return true;
    }
}