public class Example05 {
    //TODO: create the loading runnable
    //TODO: create the task runnable
    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(new TaskRunnable());
        Thread loadingThread = new Thread(new LoadingRunnable());
        //TODO: start the task thread
        //TODO: start the loading thread
        //TODO: interrupt the loading thread when the task thread is done processing
        //TODO: print a message showing that the task is done
    }
}
