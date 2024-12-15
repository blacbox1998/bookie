package group.luka.bookie;

import group.luka.bookie.model.CalendarItemAllocation;
import group.luka.bookie.model.ReservationType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceCalendarServiceImpl implements ResourceCalendarService {

    @Override
    public List<CalendarItemAllocation> findResourceScheduleForDate(Date date, Integer resource, ReservationType reservationType) {

        List<CalendarItemAllocation> result = new ArrayList<>();
        List<Date> dates = generatePeriodsForDate(date, reservationType);

        boolean busy = false;
        for (Date dateToCheck : dates) {
            CalendarItemAllocation calendarItemAllocation = new CalendarItemAllocation();
            calendarItemAllocation.setBusy(busy);
            busy = !busy;
            calendarItemAllocation.setStartedAt(dateToCheck);
            result.add(calendarItemAllocation);
        }

        return result;
    }

    private List<Date> generatePeriodsForDate(Date date, ReservationType type) {
        List<Date> dates = new ArrayList<>();

        //08:00
        Date workingDayStart = new Date(date.getTime() + 1000 * 60 * 60 * 8);
        Date workingDayEnd = new Date(workingDayStart.getTime() + 1000 * 60 * 60 * 8);

        Date tempDate = new Date(workingDayStart.getTime());
        while (tempDate.before(workingDayEnd)) {
            dates.add(tempDate);
            tempDate = new Date(tempDate.getTime() + 1000L * 60 * type.getDurationInMinutes());
        }

        return dates;
    }

    @Override
    public String getRawpServiceName() {
        return "ResourceCalendarService";
    }

}
