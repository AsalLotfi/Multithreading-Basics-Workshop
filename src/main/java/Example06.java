import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Example06 {
    static class TaskRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner (new File("C:\\Users\\Notebook\\Ap-course\\Multithreading-Basics-Workshop\\src\\main\\resources\\plain-text-passwords.txt"));
                PrintWriter writer = new PrintWriter (new FileWriter("C:\\Users\\Notebook\\Ap-course\\Multithreading-Basics-Workshop\\src\\main\\resources\\hashed-passwords.txt"));

                while (scanner.hasNextLine()) {
                    String password = scanner.nextLine().trim();
                    if(!password.isEmpty()) {
                        String hashed = hashPassword(password);
                        writer.println(hashed);
                    }
                }
                System.out.println("\nHashed passwords saved to hashed-passwords.txt");

            } catch (IOException e) {
                System.err.println("File error: " + e.getMessage());
            }
        }
    }

    static class LoadingRunnable implements Runnable {

        @Override
        public void run() {

            System.out.print("Loading");
            for (int i = 0; !Thread.currentThread().isInterrupted(); i++) {

                if (i % 6 == 0) System.out.print(".");
                if (i % 6 == 1) System.out.print(".");
                if (i % 6 == 2) System.out.print(".");
                if (i % 6 == 3) System.out.print("\b");
                if (i % 6 == 4) System.out.print("\b");
                if (i % 6 == 5) System.out.print("\b");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            //Convert to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(new Example06.TaskRunnable());
        System.out.println("Started...");
        taskThread.start();

        Thread loadingThread = new Thread(new Example06.LoadingRunnable());
        loadingThread.start();

        taskThread.join();
        loadingThread.interrupt();
        System.out.println("\nFinished...");
    }
}
