package object.ch2;

public class TestMain {
	/*
	 * @Test public void checkAmountDiscountPolicy() { Movie avatar = new
	 * Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), new
	 * AmountDiscountPolicy(Money.wons(800), new SequenceCondition(1), new
	 * SequenceCondition(10), new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,
	 * 0), LocalTime.of(11, 59)))); Screening screening = new Screening(avatar, 2,
	 * LocalDateTime.of(2021, 6, 7, 10, 30));
	 * 
	 * Assertions.assertEquals(Money.wons(9200.0).getAmount(),
	 * (screening.calculateFee(1).getAmount())); }
	 * 
	 * @Test public void checkAmountDiscountPolicyNotExpectedCondition() { Movie
	 * avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), new
	 * AmountDiscountPolicy(Money.wons(800), new SequenceCondition(1), new
	 * SequenceCondition(10), new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,
	 * 0), LocalTime.of(11, 59)))); Screening screening = new Screening(avatar, 2,
	 * LocalDateTime.of(2021, 6, 8, 10, 30));
	 * 
	 * Assertions.assertEquals(Money.wons(10000.0).getAmount(),
	 * (screening.calculateFee(1).getAmount())); }
	 * 
	 * @Test public void checkNoneDiscountPolicy() { Movie avatar = new
	 * Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000), new
	 * NoneDiscountPolicy()); Screening screening = new Screening(avatar, 2,
	 * LocalDateTime.of(2021, 6, 8, 10, 30));
	 * 
	 * Assertions.assertEquals(Money.wons(10000.0).getAmount(),
	 * (screening.calculateFee(1).getAmount())); }
	 */
}
