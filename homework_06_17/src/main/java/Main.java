import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

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

        System.out.println(
                emps
                        .stream()
                        .map(e -> e.getName().split(" ")[0])
                        .reduce((string, string2) -> string + " " + string2)
                        .orElse("")
        );

        System.out.println(
                emps
                        .stream()
                        .filter(e -> e.getAge() < 40)
                        .max(Comparator.comparingInt(Emp::getAge))
                        // не понятно, какой вставлять аргумент в .orElse
                        .map(Emp::getPosition)
        );
    }
}
