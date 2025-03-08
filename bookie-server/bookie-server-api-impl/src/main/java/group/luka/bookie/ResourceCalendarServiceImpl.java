package group.luka.bookie;

import group.luka.bookie.entity.ReservationEntity;
import group.luka.bookie.model.CalendarItemAllocation;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.repo.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceCalendarServiceImpl implements ResourceCalendarService {

    private final ReservationRepository repository;

    public ResourceCalendarServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CalendarItemAllocation> findResourceScheduleForDate(Date date, Integer resource, ReservationType reservationType) {

        Date endDate = new Date(date.getTime() + 1000 * 60 * 60 * 24);
        List<ReservationEntity> allAllocations = repository.findByResourceAndDateTimeBetween(resource, date, endDate);

        List<CalendarItemAllocation> result = new ArrayList<>();
        List<Date> dates = generatePeriodsForDate(date, reservationType.getDurationInMinutes());

        for (Date dateToCheck : dates) {
            CalendarItemAllocation calendarItemAllocation = new CalendarItemAllocation();
            calendarItemAllocation.setStartedAt(dateToCheck);

            Date intervalStart = new Date(dateToCheck.getTime() - 1000 * 60 * 2+1000*60*5);
            Date intervalEnd = new Date(dateToCheck.getTime() + 1000L * 60 * reservationType.getDurationInMinutes()-1000*60*5);
            calendarItemAllocation.setBusy(allAllocations.stream().anyMatch(allocation -> {
                Date allocationStartDate = new Date(allocation.getDateTime().getTime());
                Date allocationEndDate = new Date(allocation.getDateTime().getTime() + 1000L * 60 * allocation.getType().getDurationInMinutes());
                return allocationStartDate.before(intervalEnd)
                        && allocationEndDate.after(intervalStart);
            }));
            result.add(calendarItemAllocation);
        }

        return result;
    }

    private List<Date> generatePeriodsForDate(Date date, Integer intervalLengthInMinutes) {
        List<Date> dates = new ArrayList<>();

        //08:00
        Date workingDayStart = new Date(date.getTime() + 1000 * 60 * 60 * 8);
        Date workingDayEnd = new Date(workingDayStart.getTime() + 1000 * 60 * 60 * 8);

        Date tempDate = new Date(workingDayStart.getTime());
        while (tempDate.before(workingDayEnd)) {
            dates.add(tempDate);
            tempDate = new Date(tempDate.getTime() + 1000L * 60 * intervalLengthInMinutes);
        }

        return dates;
    }

}
