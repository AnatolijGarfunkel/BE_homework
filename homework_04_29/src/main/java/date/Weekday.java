package date;

public enum Weekday {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayNumber;

    Weekday(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public boolean isWeekDay () {
        return ordinal() < 5;
    }

    public boolean isWeekEnd() {
        return ordinal() > 4;
    }
}
