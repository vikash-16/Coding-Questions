package MultiThreading.Synchronization.Locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod() {
        lock.tryLock();
        try {
            System.out.println("outer method");
            inerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void inerMethod() {
        lock.tryLock();
        try {
            System.out.println("iner method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReetrantExample reetrantExample = new ReetrantExample();
        reetrantExample.outerMethod();
    }
}
