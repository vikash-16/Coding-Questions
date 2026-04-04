package DSAPractice;


import java.util.concurrent.Semaphore;

public class OddEvenPrinter {
    private static final Semaphore lock = new Semaphore(1);
    private static int currentNumber = 1;

    public static void main(String[] args) {
        // Create two threads
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // Start the threads
        evenThread.start();
        oddThread.start();
    }

    public static void printOdd() throws InterruptedException {
        while (currentNumber <= 10) {
            lock.acquire();
            if (currentNumber % 2 == 1) {
                System.out.println("Thread 1 (Odd): " + currentNumber);
                currentNumber++;
            }
            lock.release();
        }
    }

    public static void printEven() throws InterruptedException {
        while (currentNumber <= 10) {
            lock.acquire();
            if (currentNumber % 2 == 0) {
                System.out.println("Thread 2 (Even): " + currentNumber);
                currentNumber++;
            }
            lock.release();
        }
    }
}

