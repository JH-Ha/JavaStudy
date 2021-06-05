package object.ch2;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
	@Test
	public void checkAmountDiscountPolicy() {
		Movie avatar = new Movie("æ∆πŸ≈∏", Duration.ofMinutes(120), Money.wons(10000),
				new AmountDiscountPolicy(Money.wons(800), new SequenceCondition(1), new SequenceCondition(10),
						new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));
		Screening screening = new Screening(avatar, 2, LocalDateTime.of(2021, 6, 7, 10, 30));

		Assertions.assertEquals(Money.wons(9200.0).getAmount(), (screening.calculateFee(1).getAmount()));
	}
}
