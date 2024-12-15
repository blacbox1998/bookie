package group.luka.bookie.model;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarItemAllocation {

    private Date startedAt;
    private boolean busy;

}
