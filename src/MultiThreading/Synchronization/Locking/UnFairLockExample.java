package MultiThreading.Synchronization.Locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnFairLockExample {
    private final Lock unfairlock = new ReentrantLock();
    public void accessResource() {
        unfairlock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Aquired the lock");
            Thread.sleep(100);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName()+ "Release the lock");
            unfairlock.unlock();
        }
    }

    public static void main(String[] args) {
        UnFairLockExample example = new UnFairLockExample();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread t1 = new Thread(runnable,"thread-1");
        Thread t2 = new Thread(runnable,"thread-2");
        Thread t3 = new Thread(runnable,"thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}
