import java.util.concurrent.atomic.AtomicInteger;

/*
(x) 3. Создайте класс AtomicTester
a. создайте в нем статическое поле counter типа AtomicInteger со значением 10
b. создайте в нем статический метод decrease5 который принимает на вход AtomicInteger и
    пять раз уменьшает его (decrementAndGet)
c. Создайте и запустите два потока, каждый из которых выполняет метод decrease5 передавая туда counter
d. В методе main дождитесь окончания работы потоков (join()) и
     распечатайте значение counter
*/
public class AtomicTester {
    static AtomicInteger counter = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> decrease5(counter));
        Thread t2 = new Thread(() -> decrease5(counter));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }

    public static void decrease5 (AtomicInteger counter) {
        counter.decrementAndGet();
        counter.decrementAndGet();
        counter.decrementAndGet();
        counter.decrementAndGet();
        counter.decrementAndGet();
    }
}
