package object.ch2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		// TODO Auto-generated method stub
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
				&& startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
				&& endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
	}

}
