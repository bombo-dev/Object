package object.domain.discount;

import object.domain.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalDateTime startTime, LocalDateTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                parseLocalTime(startTime).isBefore(screening.getStartTime().toLocalTime()) &&
                parseLocalTime(endTime).isAfter(screening.getStartTime().toLocalTime());
    }

    private LocalTime parseLocalTime(LocalDateTime time) {
        return LocalTime.of(time.getHour(), time.getMinute(), time.getSecond());
    }
}
