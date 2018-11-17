package PicoPlaca;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PicoyPlaca {

    private static final LocalTime MORNING_START_TIME = LocalTime.parse("07:00:00");
    private static final LocalTime MORNING_END_TIME = LocalTime.parse("09:30:00");
    private static final LocalTime AFTERNOON_START_TIME = LocalTime.parse("16:00:00");
    private static final LocalTime AFTERNOON_END_TIME = LocalTime.parse("19:30:00");

    private LocalDateTime date;
    private Plate plate;

    public PicoyPlaca(LocalDateTime date, Plate plate) {
        this.date = date;
        this.plate = plate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public boolean isCarAllowed() {
        if (plate.getRestrictedDay() == DayOfWeek.from(date)) {
            LocalTime time = LocalTime.from(date);
            return !((time.isAfter(MORNING_START_TIME) && time.isBefore(MORNING_END_TIME)) ||
                    (time.isAfter(AFTERNOON_START_TIME) && time.isBefore(AFTERNOON_END_TIME)));
        }
        return true;
    }
}
