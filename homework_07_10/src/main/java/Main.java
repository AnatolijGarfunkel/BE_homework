import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("Cuba", "Ecuador", "Brazil", "Canada");
        int [] el = {1, 2};
        System.out.println("1) \n" + getElements(list, el) + " \n");

        /*
        Каким днём недели был день возвращения Колумба из его первого плавания в америку (15 марта 1493)
         */
        LocalDate columb = LocalDate.of(1493, Month.MARCH, 15);
        System.out.println("2) \n" + columb.getDayOfWeek() + "\n");

        /*
        Распечатайте количество секунд, прошедшие между днем взятия Бастилии (14 июля 1789)
        и полетом в космос Гагарина (12 апреля 1961)
        */

        LocalDate bastil = LocalDate.of(1789, Month.JULY, 14);
        LocalDate gagarin = LocalDate.of(1961, Month.APRIL, 12);
        
        // Согласен, выглядит из пальца вытянуто. У меня цель вас догнать, поэтому.
        System.out.println("3) \n" + ChronoUnit.DAYS.between(gagarin, bastil) * 24 * 60 * 60 + "\n");

    }
    /*
    (x) Напишите шаблонную функцию, которая принимает на вход список чего угодно и varargs из целых.
    Нужно вернуть коллекцию из элементов, номера которых и передаются в виде varargs
    public static <T> Collection<T> getElements(List<T> list, int ... elements)
    Например, если в функцию передается список ["Cuba", "Ecuador", "Brazil", "Canada"] и
    номера 1 и 2, то нужно вернуть коллекцию из ["Ecuador", "Brazil"]
    На всякий случай, доступ к varargs происходит аналогично элементам массива
    */

    public static <T> Collection<T> getElements(List<T> list, int ... elements) {
        List<T> map = new ArrayList<>();
        for (int i = 0; i < elements.length; i ++) {
            map.add(list.get(elements[i]));
        }
        return map;
    }
}
