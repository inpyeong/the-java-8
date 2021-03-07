package dateAndTime.two;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        // 기계용 API..
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);


        System.out.println("------------------------------------");

        // 사람용 API..
        // instant, Localtime, ZonedDateTime 서로 변환 가능
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1996, Month.OCTOBER, 2, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        System.out.println(nowInKorea);

        System.out.println("------------------------------------");

//        Period 는 사람용 시간 비교..

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate thisYearBirthday = LocalDate.of(2021, Month.OCTOBER, 2);
        System.out.println(thisYearBirthday);
        Period between = Period.between(today, thisYearBirthday);
        System.out.println(between.getDays());
        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));


        System.out.println("------------------------------------");


//        Duration 은 기계용 시간 비교..
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(now1, plus);
        System.out.println(between1.getSeconds());


        System.out.println("------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(localDateTime.format(dateTimeFormatter));

        LocalDate parse = LocalDate.parse("10/02/1996", dateTimeFormatter);
        System.out.println(parse);


        System.out.println("------------------------------------");


        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime1);

        ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId1);
    }
}
