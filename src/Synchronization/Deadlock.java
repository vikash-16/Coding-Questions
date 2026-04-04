package Synchronization;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        final String resource1 = "hello";
        final String resource2 = "world";
        final String resource3 = "string3";
        final String resource4 = "string4";
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 : locked resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource2) {
                    System.out.println("Thread 1 : locked resource 2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 : locked resource 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource3) {
                    System.out.println("Thread 2 : locked resource 3");
                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (resource3) {
                System.out.println("Thread 3 : locked resource3");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource4) {
                    System.out.println("Thread 3 : locked resource 4");
                }
            }
        });
        Thread t4 = new Thread(() -> {
            synchronized (resource4) {
                System.out.println("Thread 4 : locked resource 4");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource1) {
                    System.out.println("Thread 4 : locked resource 1");
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
