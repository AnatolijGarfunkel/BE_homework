import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n1)\n");
        System.out.println(getList("michael;levanov|34|34000"));

        System.out.println("\n2)\n");
        System.out.println(changeString("Today's temperature is 18 degrees centigrade, yesterday it was 14"));

        System.out.println("\n3)\n");
        System.out.println(isGoodPassword("1$abc123444")); // true
        System.out.println(isGoodPassword("1abc123444")); // false
        System.out.println(isGoodPassword("%abcabcacb")); // false
        System.out.println(isGoodPassword("1%a!v")); // false

        System.out.println("\n4)\n");
        System.out.println(isDate("24 jan 2001")); // true
        System.out.println(isDate("2 FEB 2014")); // true
        System.out.println(isDate("2 FEB 22010")); // true
        System.out.println(isDate("12")); // false
        System.out.println(isDate("12 jun")); // false
        System.out.println(isDate("14 HHH 2222")); // false

        System.out.println("\n5)\n");
        System.out.println(isAlternateDate("29 FEB 2000")); // true
        System.out.println(isAlternateDate("29 FEB 2022")); // false
        System.out.println(isAlternateDate("42 MAR 2014")); // false

        System.out.println("\n6)\n");
        System.out.println(extractUrlFromLink("<a href='https://www.goolge.com'>link</a>")); // https://www.goolge.com/
        System.out.println(extractUrlFromLink("<a href='ftp://ftp.ya'>file on ftp</a>")); // ftp://ftp.ya (Bearbeitet)

    }

    /*
    Дана строка "michael;levanov|34|34000"
    Разбейте ее по резделителям (;|) и распечатайте составные части
    */

    public static List getList (String s) {
        String[] strings = s.split(";");

        List<String> list = new ArrayList<>();
        list.add(strings[0]);
        list.addAll(List.of(strings[1].split("\\|")));
        return list;
    }

    /*
    В строке "Today's temperature is 18 degrees centigrade, yesterday it was 14"
    Замените все чиcла на 21 и замените centi на multi
    */

    public static String changeString (String s) {
        return s.replaceAll("\\d+", "21")
                .replaceAll("centi", "multi");
    }

    /*
    Напишите метод isGoodPassword(String) проверяющий пароль на "хорошесть"
    Хороший пароль длиной не менее 8 символов, содержит как минимум одну цифру
    и как минимум один знак из набора !@%#^&$|
    В методе можно написать несколько проверок
    */

    public static boolean isGoodPassword(String s) {
        return s.length() > 8
                && s.matches(".*\\d.*")
                && s.matches(".*[!@%#^&$|].*");
    }

    /*
    Напишите метод isDate(String) который проверит, что передаваемая строка является датой.
    Дата выглядит как "24 jan 2001" - день месяца, месяц и год
    Месяцы могут быть только jan, feb, mar и тп в нижнем и в верхнем регистрах
    */

    public static boolean isDate(String s) {


        return s.toLowerCase().matches("\\d{1,2}\\s(jan|feb|mar|apr|mai|jun|jul|aug|sep|oct|nov|dec)\\s\\d{1,}");
    }

    /*
    (xx) То же что в пункте 4, но с учетом высокосности и правильного количества дней в месяцах
     System.out.println(isDate("29 FEB 2000")); // true
     System.out.println(isDate("29 FEB 2022")); // false
     System.out.println(isDate("42 MAR 2014")); // false
    */

    public static boolean isAlternateDate(String s) {
        Map<String, Integer> map = getMap("months.txt");
        String month = "";
        int day = 0, year = 0;
        s = s.toLowerCase();

        Pattern date = Pattern.compile("(\\d{1,2})\\s(\\w{3})\\s(\\d{1,})");
        Matcher matcher = date.matcher(s);
        while (matcher.find()) {
            day = Integer.parseInt(matcher.group(1));
            month = matcher.group(2);
            year = Integer.parseInt(matcher.group(3));
        }

        String finalMonth = month;
        if (map.entrySet()
                .stream()
                .noneMatch(
                        stringIntegerEntry -> stringIntegerEntry.getKey().equals(finalMonth)
                )
        )
            return false;

        if (day <= getMonthsDay(map.get(month), year))
            return true;

        return false;
    }

    public static Map<String, Integer> getMap (String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try (
                Reader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] lines = line.split(" ");
                map.put(lines[0], Integer.parseInt(lines[1]));
                line = bufferedReader.readLine();
            }
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return map;
    }


    public static int getMonthsDay (int month, int year) {
        if (month == 2) {
            return getFebDays(year);
        }
        if (month <= 7) {
            return  month % 2 == 0 ? 30 : 31;
        }
        else {
            return month % 2 == 0 ? 31 : 30;
        }
    }


    public static int getFebDays (int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 !=0))) {
            return 29;
        }
        else
            return 28;
    }

    /*
    (xxx) Напишите метод extractUrlFromLink(String) выкусывающий url из ссылки html

        System.out.println(extractUrlFromLink("<a href='https://www.goolge.com'>link</a>")); // https://www.goolge.com/
        System.out.println(extractUrlFromLink("<a href='ftp://ftp.ya'>file on ftp</a>")); // ftp://ftp.ya (Bearbeitet)

    */

    public static String extractUrlFromLink(String s) {

        int first = s.indexOf("'") + 1;
        int last = s.lastIndexOf("'");

        return s.substring(first, last);
    }

}
