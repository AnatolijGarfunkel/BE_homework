public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person alex = new Person("Alex", 37);

        Phone[] phone = new Phone[3];
        phone[0] = new Phone(11, "Samsung", 500);
        phone[1] = new Phone(12, "Nokia", 550);
        phone[2] = new Phone(13, "Motorolla", 600);

        for (int i = 0; i < phone.length; i ++) {
            phone[i].printPhoneInfo();
        }

        phone[0].receiveCall(alex.getFullName());
    }
}
