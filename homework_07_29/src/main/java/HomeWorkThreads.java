/*
(x) 2. Создайте класс HomeWorkThreads
a создайте в нем два целых статических поля result1 и result2
b. создайте в нем метод public static int waitSomeTime который
     спит рандомное время от 0 до 1000 мс и
     возвращает это время в качестве результата
c. Создайте и запустите два потока, каждый из которых выполняет метод waitSomeTime и
     первый сохраняет результат в поле result1
     второй сохраняет результат в поле result2
d. В методе main дождитесь окончания работы потоков (join()) и
     распечатайте сумму result1 и result2

 */

import java.awt.*;
import java.util.Random;

public class HomeWorkThreads {
    static int result1;
    static int result2;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> result1 = waitSomeTime());
        Thread t2 = new Thread(() -> result2 = waitSomeTime());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result1 + result2);

    }

    public static int waitSomeTime () {
        Random random = new Random();
        int time = random.nextInt(1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return time;
    }
}
