import java.util.Random;
import java.util.concurrent.*;

public class HomeWorkCallable {
    /*
    (x)2. Создайте класс HomeWorkCallable
    a. создайте в нем метод public static int waitSomeTime который
    спит рандомное время от 0 до 1000 мс и
    возвращает это время в качестве результата
    b. Создайте и запустите два Callable каждый из которых выполняет waitSomeTime и возвращает результат
    с. В main получите и сложите эти результаты, запустив эти Callable на двух потоках используя FutureTask
    */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TimeCall call1 = new TimeCall();
        TimeCall call2 = new TimeCall();
        FutureTask<Integer> task1 = new FutureTask<>(call1);
        FutureTask<Integer> task2 = new FutureTask<>(call2);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int result1 = task1.get();
        System.out.println(result1);
        int result2 = task2.get();
        System.out.println(result2);

        System.out.println(result1 + result2);
    }

    public static class TimeCall implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return waitSomeTime();
        }
    }

    public synchronized static int waitSomeTime () {
        int time = new Random().nextInt(1000);
        return time;
    }
}
