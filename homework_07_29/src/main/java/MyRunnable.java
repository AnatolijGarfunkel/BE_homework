/*
Создать класс MyRunnable который
a. принимает на вход список строк
b. распечатывает каждый элемент и ждет одну секунду перед распечатыванием следующего элемента
c. создать и запустить поток, принимающий экземпляр этого Runnable с произвольным списком
*/
public class MyRunnable implements Runnable{
    private String[] strings;

    public MyRunnable(String[] strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        for (String data: strings) {
            System.out.println(data);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


