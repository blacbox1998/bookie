package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.CalendarItemAllocation;
import group.luka.bookie.model.ReservationType;

import java.util.Date;
import java.util.List;

public interface ResourceCalendarService extends RawpServiceComponent {

    List<CalendarItemAllocation> findResourceScheduleForDate(Date date, Integer resource, ReservationType reservationType);

}
