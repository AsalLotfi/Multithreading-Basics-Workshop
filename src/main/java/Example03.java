public class Example03 {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; !Thread.currentThread().isInterrupted() ; i++) {
                System.out.println("Hi from " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Hi from " + Thread.currentThread().getName());
        Thread thread = new Thread(new MyRunnable());
        System.out.println("state: " + thread.getState());
        thread.start();
        System.out.println("state: " + thread.getState());
        Thread.sleep(4000);
        thread.interrupt();
        System.out.println("state: " + thread.getState());
        Thread.sleep(1000);
        System.out.println("state: " + thread.getState());
    }
}