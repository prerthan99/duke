package sharadhr.duke.task;

import java.time.ZonedDateTime;

import sharadhr.duke.exception.DukeEmptyDetailException;
import sharadhr.duke.exception.DukeInvalidDateException;

/**
 * An Event, with a detail, a start time, and an end time.
 */
public class Event extends Task
{
    protected String duration;
    
    protected ZonedDateTime startTime;
    protected ZonedDateTime endTime;
    
    Event(String detail, ZonedDateTime startTime, ZonedDateTime endTime) throws DukeEmptyDetailException
    {
        super(detail);
        
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    /**
     * Creates an Event with a specified detail, and a {@link String} that specifies
     * the duration of the Event. The actual starting and ending
     * {@link ZonedDateTime} instance variables are parsed from this string.
     * 
     * @param detail The Event detail
     * @param timeString the {@link String} describing the duration of the event
     * @throws DukeEmptyDetailException if {@code detail} is blank (as specified by {@link String#isBlank()})
     * @throws DukeInvalidDateException if the date cannot be parsed into a starting and ending date
     */
    public Event(String detail, String timeString) throws DukeEmptyDetailException, DukeInvalidDateException
    {
        this(detail, ZonedDateTime.now(), ZonedDateTime.now());
    }

    
    public char getTaskTypeIcon()
    {
        return 'E';
    }
    
    @Override
    public String toString()
    {
        return String.format("[%c]%s (at: %s)", this.getTaskTypeIcon(), super.toString(), this.duration);
    }
    
    @Override
    public String encode()
    {
        return String.format("%c,%d,%s,%s,%s", this.getTaskTypeIcon(), this.complete ? 1 : 0, this.detail,
                this.startTime);
    }
}