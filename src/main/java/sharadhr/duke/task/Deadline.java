package sharadhr.duke.task;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import sharadhr.duke.exception.DukeEmptyDetailException;
import sharadhr.duke.exception.DukeInvalidDateException;

/**
 * A Deadline, with a date-time group when it is due.
 */
public class Deadline extends Task
{
    private ZonedDateTime by;
    
    Deadline(String detail, ZonedDateTime by) throws DukeEmptyDetailException
    {
        super(detail);
        this.by = by;
    }
    
    /**
     * Creates a deadline with a specified detail, and a date-time to be done by.
     * 
     * @param detail the deadline detail
     * @param by     the date-time to be done by
     * @throws DukeEmptyDetailException
     * @throws DukeInvalidArgumentException if the detail is empty.
     */
    public Deadline(String detail, String by) throws DukeEmptyDetailException, DukeInvalidDateException
    {
        this(detail, ZonedDateTime.now());
    }
    
    @Override
    public char getTaskTypeIcon()
    {
        return 'D';
    }
    
    @Override
    public String toString()
    {
        return String.format("[%c]%s (by: %s)", this.getTaskTypeIcon(), super.toString(), this.by);
    }
    
    @Override
    public String encode()
    {
        return String.format("[%c]%s (due on: %s)", this.getTaskTypeIcon(), super.toString(),
                this.by.format(DateTimeFormatter.ofPattern("dd/MMM/uuuu hh:mma z")));
    }
    
    // @Override
    // public String toString()
    // {
    //     return String.format("[%c]%s (by: %s)", this.getTaskTypeIcon(), super.toString(),
    //             this.byString);
    // }
}