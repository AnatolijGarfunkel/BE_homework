import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        Создайте класс Student с полями
        String name
        int age
        String major
        Добавьте геттеры/сеттеры и конструктор со всеми полями
        Сделайте так, чтобы коллекции студентов могли без компаратора сортироваться по имени.
         */

        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("Marcus", 24, "Mathematic"),
                        new Student("Khaled", 24, "Medicin"),
                        new Student("Alex", 21, "Philosophy"),
                        new Student("Martin", 22, "IT")
                )
        );

        Collections.sort(students);
        System.out.println(students);

        /*
        Отсортируйте коллекцию студентов по убыванию возраста и по возрастанию специальности (major)
         */
        Comparator<Student> ageComp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        Comparator<Student> majComp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMajor().compareTo(o2.getMajor());
            }
        };


        /*
        3. Напишите метод, принимающий на вход коллекцию студентов и массив их компраторов
        Внутри метода отсортируйте коллекцию, создав сложный компаратор из всех переданных в массиве
        public static void sort(Collection<Student> students, Comparator<Student> [] comps)
        */


        Comparator<Student> [] comparators = new Comparator[2];
        comparators[0] = ageComp;
        comparators[1] = majComp;

        sort(students, comparators);
    }

    public static void sort(List<Student> students, Comparator<Student> [] comps) {
        Collections.sort(students, comps[1].thenComparing(comps[0].reversed()));
    }
}








































