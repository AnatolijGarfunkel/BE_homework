public class Main {
    public static void main(String[] args) {
        String [] strings = {"принимает", "на", "вход", "список", "строк"};
        Runnable runnable = new MyRunnable(strings);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
