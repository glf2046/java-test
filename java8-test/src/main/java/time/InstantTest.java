package time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * @author guff
 * @since 2019-05-3:24 PM
 */
public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant2 = Instant.ofEpochSecond(120, 100000);
        System.out.println(instant2);

        LocalDate date = LocalDate.of(2017, 1, 5);
        date.with(temporal -> {
            // 当前日期
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            System.out.println(dayOfWeek);

            // 正常情况下，每次增加一天
            int dayToAdd = 1;

            // 如果是星期五，增加三天
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }

            // 如果是星期六，增加两天
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }
}
