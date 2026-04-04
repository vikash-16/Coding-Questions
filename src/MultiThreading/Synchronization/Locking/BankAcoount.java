package MultiThreading.Synchronization.Locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAcoount {
    private int balance = 100;

    /*synchronized public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw "+ amount);
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " Processing to withdraw ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + " Complete withdraw.Remaining amount "+ balance);
        }else {
            System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
        }
    }*/

    /*Problem is that if t1 access first then it will process and if sytem takes time due to logic then thread t2 have to wait for longer time which is problem to overcome this problem Lock will come into picture*/

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw "+ amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Processing to withdraw ");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Complete withdraw.Remaining amount " + balance);
                    }catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " count not aquire lock, will try later " );
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    /*thead-2 Attempting to withdraw 50
thread-1 Attempting to withdraw 50
thead-2 Processing to withdraw
thread-1 count not aquire lock, will try later
thead-2 Complete withdraw.Remaining amount 50*/
}
