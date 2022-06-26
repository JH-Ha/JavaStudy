package modernJavaInAction.ch12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.TimeZone;

public class Main {
	public static void main(String[] args) {
		// deprecated Date
		Date date = new Date(117, 8, 21);
		System.out.println(date);

		LocalDate localDate = LocalDate.of(2021, 3, 15);
		System.out.println(localDate);

		int year = localDate.get(ChronoField.YEAR);
		System.out.println(year + " " + localDate.getYear());

		LocalTime localTime = LocalTime.of(13, 45, 15);
		System.out.println(localTime);

		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTime);

		int num = 1_000_000;
		System.out.println(num);

		// duration
		Duration d1 = Duration.between(localDateTime.minusMonths(1), localDateTime);
		System.out.println(d1.toString());

		// period
		Period tenDays = Period.ofDays(10);
		System.out.println(tenDays);

		// 12.2.1 Temporal Adjusters

		LocalDate date1 = LocalDate.of(2017, 9, 21);
		LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		LocalDate date3 = date1.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);

		// 12.2
		String s1 = date1.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(s1);

		// 12.3.1 timezone
		ZoneId romeZone = ZoneId.of("Europe/Rome");
		ZoneId seoulZone = ZoneId.of("Asia/Seoul");
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
		ZonedDateTime zd2 = dateTime.atZone(romeZone);

		System.out.println("dateTime : " + dateTime + " zd2 : " + zd2 + " zd2 to localDateTime ");
		ZonedDateTime zd3 = zd2.withZoneSameLocal(seoulZone);
		System.out.println(zd3);
		ZonedDateTime zd4 = zd3.withZoneSameInstant(seoulZone);
		System.out.println(zd4);

		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		DateFormat estFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
		estFormat.setTimeZone(TimeZone.getTimeZone("EST"));
		try {
			String date10 = estFormat.format(utcFormat.parse("2018-04-15T21:27:31.000Z"));
			System.out.println("est time : " + date10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
