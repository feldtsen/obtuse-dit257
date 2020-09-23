package model.util;

import application.model.util.InvalidChronologicalOrderException;
import application.model.util.InvalidLocalDateTimeException;
import application.model.util.TimeRange;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class TimeRangeTest {

    @Test
    public void validTest() {
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        LocalDateTime end = LocalDateTime.now().plusDays(3);

        try {
            new TimeRange(start, end);
        } catch (InvalidLocalDateTimeException | InvalidChronologicalOrderException e) {
            fail();
        }
        assertTrue(true);
    }

    @Test
    public void justValidTest() {
        LocalDateTime start = LocalDateTime.now().minusHours(1).plusSeconds(1);
        LocalDateTime end = LocalDateTime.now().plusDays(2);

        try {
            new TimeRange(start, end);
        } catch (InvalidLocalDateTimeException | InvalidChronologicalOrderException e) {
            fail();
        }
        assertTrue(true);
    }

    @Test(expected = InvalidLocalDateTimeException.class)
    public void invalidStartBeforeNowTest() throws InvalidLocalDateTimeException {
        LocalDateTime start = LocalDateTime.now().minusHours(2);
        LocalDateTime end = LocalDateTime.now().plusDays(2);

        try {
            new TimeRange(start, end);
        } catch (InvalidChronologicalOrderException e) {
            fail();
        }
    }

    @Test(expected = InvalidLocalDateTimeException.class)
    public void invalidStartAndEndBeforeNowTest() throws InvalidLocalDateTimeException {
        LocalDateTime start = LocalDateTime.now().minusHours(3);
        LocalDateTime end = LocalDateTime.now().minusHours(2);

        try {
            new TimeRange(start, end);
        } catch (InvalidChronologicalOrderException e) {
            fail();
        }
    }

    @Test(expected = InvalidChronologicalOrderException.class)
    public void invalidIsNotChronological() throws InvalidChronologicalOrderException {
        LocalDateTime start = LocalDateTime.now().plusDays(2);
        LocalDateTime end = LocalDateTime.now().plusDays(1);

        try {
            new TimeRange(start, end);
        } catch (InvalidLocalDateTimeException e) {
            fail();
        }
    }
}
