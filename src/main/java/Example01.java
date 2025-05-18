public class Example01 {
    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 25 ; i++) {
                System.out.println("Hi from " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args)
    {
        Thread.currentThread().setName("MyThread");
        Thread thread = new MyThread();
        thread.start();

        for (int i = 0; i < 25 ; i++) {
            System.out.println("Hi from " + Thread.currentThread().getName());
        }
    }
}
