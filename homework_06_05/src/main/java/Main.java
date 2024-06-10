import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        1. Создайте метод, принимающий на вход массив строк и массив целых одинаковой длины и возвращающий Map
        public static Map makeMap(String [] strings, int [] ints)
        Например: ["Dima", "Masha"], [23,33] -> [{"Dima":23}, {"Masha", 33}].

         */

        String [] strings = {"Dima", "Masha"};
        int [] ints = {23, 33};
        System.out.println(makeMap(strings, ints));

        /*
        2. Верните самую часто встречающуюся строку в списке строк
        public static String mostFrequentString(List strings)

         */

        String s = "один раз это один раз но только раз";
        List<String> list = new ArrayList<>();
        for (String data: s.split(" ")) {
            list.add(data);
        }
        System.out.println(mostFrequentStrings(list));

        /*
        3. Сгруппируйте слова с одинаковым набором символов
        Один и те-же символы могут встречаться несколько раз
        public static List> getWords(List strings)
        Например: ["alla", "student", "students", "al", "pass", "sap", "lalalala"] ->
        -> [["student", "students"], ["alla", "al", "lalalala"], ["pass", "sap"]]
         */

        Set<String> phrases = new LinkedHashSet<>(
                Arrays.asList("alla", "student", "students", "al", "pass", "sap", "lalalala")
        );

        System.out.println(getWords(getUniqueChars(phrases), phrases));
    }

    public static Map makeMap(String [] strings, int [] ints) {

        Map<String, Integer> data = new TreeMap<>();
        for (int i = 0; i < strings.length; i ++) {
            data.put(strings[i], ints[i]);
        }
        return data;
    }

    public static String mostFrequentStrings (List <String> strings) {
        Map <String, Integer> map = new TreeMap<>();
        String result = "";
        for (String data: strings) {
            int count = 0;
            if (map.containsKey(data)) {
                count = map.get(data);
            }
            map.put(data, ++ count);
        }
        System.out.println(map);
        int i = 0;
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            if (pair.getValue() > i) {
                i = pair.getValue();
                result = pair.getKey();
            }
        }

        return result;
    }
        /*
        3. Сгруппируйте слова с одинаковым набором символов
        Один и те-же символы могут встречаться несколько раз
        public static List> getWords(List strings)
        Например: ["alla", "student", "students", "al", "pass", "sap", "lalalala"] ->
        -> [["student", "students"], ["alla", "al", "lalalala"], ["pass", "sap"]]
         */

    public static Set<Set<Character>> getUniqueChars(Set<String> strings) {
        Set< Set<Character>> charsSet = new LinkedHashSet<>();
        Set<Character> word;

        for (String data: strings) {
            word = new LinkedHashSet<>();
            for (int i = 0; i < data.length(); i ++) {
                word.add(data.charAt(i));
            }
            charsSet.add(word);
        }
        return charsSet;
    }

    public static Set<Set<String>> getWords (Set<Set<Character>> charSet, Set<String> strings) {
        Set<String> result;
        Set<Set<String>> endResult = new LinkedHashSet<>();
        Set<Character> word;
        boolean contains = false;

        for (Set proof : charSet) {
            result = new TreeSet<>();
            for (String s : strings) {
                word = proof;
                for (Character w : word) {
                    contains = s.contains(w.toString());
                    if (!contains) {
                        break;
                    }
                }
                if (contains) {
                    result.add(s);
                }
            }
            endResult.add(result);
        }

        return endResult;
    }
}
