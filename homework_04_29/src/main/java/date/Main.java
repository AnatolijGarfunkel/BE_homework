package date;

public class Main {
    public static void main(String[] args) {

        Date date = new Date(2024, Month.AUGUST, 18);
        System.out.println(date);

        Date newDate = date.add(35);
        System.out.println(newDate);
    }
}
