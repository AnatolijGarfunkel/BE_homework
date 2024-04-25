public class Person {
    private String fullName;
    private int age;

    public Person() {

    }
    public Person(String name, int age) {
        this.fullName = name;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void move() {
        System.out.println(fullName + " is moving.");
    }

    public void talk() {
        System.out.println(fullName + " is talking.");
    }
}
