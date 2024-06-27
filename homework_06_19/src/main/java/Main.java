import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Emp> emps = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Peregudov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Nicolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Alex Reingard", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

/*
        1)
        Посчитать средний возраст всех работников используя Collectors.averagingDouble()
*/

        double averageAge;
        averageAge = emps.stream()
                .map(e -> e.getAge())
                .collect(
                        Collectors
                                .averagingDouble(value -> value)
                );

        System.out.println(1 + ")\n" + averageAge + "\n");

/*
        2)
        Найдите самого молодого работника используя Collectors.minBy() и компаратор
*/

        Emp youngest;

        youngest = emps.stream()
                .collect(
                        Collectors
                                .minBy(
                                        Comparator.comparingInt(Emp::getAge)
                                )
                )
                .orElse(null);

        System.out.println(2 + ")\n" + youngest + "\n");


/*
        3)
        Разбейте пользователей на группы по возрасту - 10-19 (1), 20-29 (2), 30-39 (3), 40-49 (4), 50-59 (5)
        и так далее лет - Map> - ключи мапы  1,2,3,4,5  и т.п. - количество полных десятков лет в возрасте
*/

        Map<Integer, Long> map1;

        map1 = emps.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> {
                                    if (emp.getAge() < 20) return 1;
                                    if (emp.getAge() < 30) return 2;
                                    if (emp.getAge() < 40) return 3;
                                    if (emp.getAge() < 50) return 4;
                                    if (emp.getAge() < 60) return 5;
                                    return 0;
                                },
                                Collectors.counting()
                        )
                );


        System.out.println(3 + ")\n" + map1 + "\n");

/*
        4)
        (xx) Вернуть средний возраст мужчин и женщин в виде Map - ключ "true" соответствует женщинам -
        воспользуйтесь Collectors.partitioningBy и Collectors.averagingDouble
*/

        Map<Boolean, Double> map2;

        map2 = emps.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.getName().endsWith("a"),
                                Collectors.averagingDouble(Emp::getAge)
                        )
                );

        System.out.println(4 + ")\n" + map2 + "\n");

/*
        5)
        (xx) Верните Map - работников с самым большим возрастом в каждой профессии -
        воспользуйтесь Collectors.groupingBy и Collectors.maxBy
*/

        System.out.println(5 + ")\n" +
                emps.stream()
                        .collect(
                                Collectors.groupingBy(
                                        e -> e.getPosition(),
                                        Collectors.maxBy(Comparator.comparingInt(Emp::getAge))
                                )
                        )
                + "\n");

        // не понимаю, куда orElse вставить, что бы от Optional избавиться

/*
        6)
        (xxx) Распечатать работников с самым часто встречающимся возрастом
*/

        // Map с возростом и частотой
        Map<Integer, Long> map3;
        map3 = emps.stream()
                .collect(
                        Collectors.groupingBy(
                                age -> age.getAge(),
                                Collectors.counting()
                        )
                );
        // нахождение самой частой частоты
        int often = Math.toIntExact(
                map3
                        .values()
                        .stream()
                        .max(
                                (o1, o2) -> {
                                    int a = Math.toIntExact(o1);
                                    int b = Math.toIntExact(o2);
                                    return a - b;
                                }
                        )
                        .orElse(0L));

        // вычленение возраста по частоте
        int age = 0;
        for (Entry<Integer, Long> pair: map3.entrySet()) {
            if (pair.getValue() == often)
                age = pair.getKey();
        }

        // нахождение работников по возрасту
        int finalAge = age;
        System.out.println(6 + ")\n" +
                emps.stream()
                        .filter(e -> e.getAge() == finalAge)
                        .toList()
        + "\n");

        // на 7-ое задание уже сил не хватает. )

    }
}



































