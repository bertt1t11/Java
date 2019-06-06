import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.temporal.*;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateTimeExample1 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before Formatting: " + now);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(format);
		System.out.println("After Formatting: " + formatDateTime);
		MonthDay month = MonthDay.now();
		long n = month.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(n);
		ValueRange r1 = month.range(ChronoField.MONTH_OF_YEAR);
		System.out.println(r1);
		ValueRange r2 = month.range(ChronoField.DAY_OF_MONTH);
		System.out.println(r2);
		OffsetTime offset = OffsetTime.now();
		int h = offset.get(ChronoField.HOUR_OF_DAY);
		System.out.println(h);
		int m = offset.get(ChronoField.MINUTE_OF_DAY);
		System.out.println(m);
		int s = offset.get(ChronoField.SECOND_OF_DAY);
		System.out.println(s);
		offset = OffsetTime.now();
		h = offset.getHour();
		System.out.println(h + " hour");
		offset = OffsetTime.now();
		s = offset.getSecond();
		System.out.println(s + " second");
		OffsetDateTime offsetDT = OffsetDateTime.now();
		System.out.println(offsetDT.getDayOfYear());

		Clock c = Clock.systemDefaultZone();
		System.out.println(c.getZone());
		c = Clock.systemUTC();
		System.out.println(c.instant());
		Year y = Year.now();
		System.out.println(y);
		Year year = Year.of(2016);
		System.out.println(year.isLeap());
		Period period = Period.ofDays(24);
		Temporal temp = period.addTo(LocalDate.now());
		System.out.println(temp);
		Duration d = Duration.between(LocalTime.NOON, LocalTime.MAX);
		System.out.println(d.get(ChronoUnit.SECONDS));

		DayOfWeek day = DayOfWeek.of(5);
		System.out.println(day.name());
		System.out.println(day.ordinal());
		System.out.println(day.getValue());
		LocalDate date = LocalDate.of(2017, Month.JANUARY, 31);
		day = DayOfWeek.from(date);
		System.out.println(day.getValue());
		day = day.minus(3);
		System.out.println(day.getValue());
		Month month2 = Month.valueOf("January".toUpperCase());
		System.out.printf("For the month of %s all Sunday are:%n", month2);
		LocalDate localdate = Year.now().atMonth(month2).atDay(1)
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		Month mi = localdate.getMonth();
		while (mi == month2) {
			System.out.printf("%s%n", localdate);
			localdate = localdate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
			mi = localdate.getMonth();
			Month month3 = Month.from(LocalDate.now());
			System.out.println(month3.getValue());
			System.out.println(month3.name());

			Month month5 = Month.from(LocalDate.now());
			System.out.println(month5.plus(2));
			System.out.println("Total Number of days: " + month5.length(true));
			long millis = System.currentTimeMillis();
			java.sql.Date dateX = new java.sql.Date(millis);
			System.out.println(dateX);
			Calendar calendar = Calendar.getInstance();
			System.out.println("The current date is : " + calendar.getTime());
			calendar.add(Calendar.DATE, -15);
			System.out.println("15 days ago: " + calendar.getTime());
			calendar.add(Calendar.MONTH, 4);
			System.out.println("4 months later: " + calendar.getTime());
			calendar.add(Calendar.YEAR, 2);
			System.out.println("2 years later: " + calendar.getTime());

			Date currentDate = new Date();
			System.out.println("Current Date: " + currentDate);

			String dateToStr = DateFormat.getInstance().format(currentDate);
			System.out.println("Date Format using getInstance(): " + dateToStr);

			dateToStr = DateFormat.getDateInstance().format(currentDate);
			System.out.println("Date Format using getDateInstance(): " + dateToStr);

			dateToStr = DateFormat.getTimeInstance().format(currentDate);
			System.out.println("Date Format using getTimeInstance(): " + dateToStr);

			dateToStr = DateFormat.getDateTimeInstance().format(currentDate);
			System.out.println("Date Format using getDateTimeInstance(): " + dateToStr);

			dateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
			System.out.println("Date Format using getTimeInstance(DateFormat.SHORT): " + dateToStr);

			dateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(currentDate);
			System.out.println("Date Format using getTimeInstance(DateFormat.MEDIUM): " + dateToStr);

			dateToStr = DateFormat.getTimeInstance(DateFormat.LONG).format(currentDate);
			System.out.println("Date Format using getTimeInstance(DateFormat.LONG): " + dateToStr);

			dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
			System.out.println("Date Format using getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT): " + dateToStr);

			Date date55 = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date55);
			System.out.println(strDate);

			formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
			strDate = formatter.format(date);
			System.out.println("Date Format with dd MMMM yyyy zzzz : " + strDate);

			formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
			strDate = formatter.format(date);
			System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : " + strDate);

			SimpleDateFormat formatterx = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date datex = new Date();
			System.out.println(formatterx.format(datex));

		}
	}
}