public class Example02 {
    static class MyRunnable implements Runnable {

        @Override
        public void run()
        {
            for (int i = 0; i < 25 ; i++) {
                System.out.println("Hi from " + Thread.currentThread().getName());
            }
        }
    }
    public static void main(String[] args)
    {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 25 ; i++) {
            System.out.println("Hi from " + Thread.currentThread().getName());
        }
    }
}
