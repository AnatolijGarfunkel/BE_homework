public class Phone {
    private int number;
    private String model;
    private double weight;

    public Phone(int number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void printPhoneInfo() {
        System.out.println("Number: " + number + ", model: " + model + ", weight: " + weight);
    }

    public void receiveCall (String name) {
        System.out.println("");
        System.out.println("Звонок от " + name);
    }
}
