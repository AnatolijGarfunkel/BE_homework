package date;

public class Date {
    private int year;
    private Month month;
    private int day;
    private Weekday weekday;

    private int dayOfTheYear;

    public Date(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfTheYear = getDayOfTheYear();
        this.weekday = Weekday.values()[dayOfTheYear % 7 == 0 ? 6 : dayOfTheYear % 7 - 1];
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getDayOfTheYear() {
        int count = 0;
        for (int i = 0; i < month.ordinal(); i ++) {
            count += getCountOfDays(i);
        }
        count += getDay();
        return count;
    }

    public int getCountOfDays (int i) {
        if (i == 1) {
            return getDaysOfFebruary();
        }
        if (i <= 6) {
            return  i % 2 == 0 ? 31 : 30;
        }
<<<<<<< HEAD
        else   {
            return  i % 2 == 0 ? 30 : 31;
=======
        else {
            return  30;
>>>>>>> d94a09c7a6ee2476c7a6ead8f4f73f013ea33360
        }
    }

    public int getDaysOfFebruary () {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 !=0))) {
            return 29;
        }
        else
            return 28;
    }

    public Date add (int days) {
        int newDate = dayOfTheYear + days;
        int newMonth = 0;
        for (int i = 0; newDate > 27; i ++) {
            newDate -= getCountOfDays(i);
            newMonth += 1;
        }
        return new Date(2024, Month.values()[newMonth], newDate);
    }


    @Override
    public String toString() {
        return weekday + " " + day + " " + month + " " + year;
    }
}
