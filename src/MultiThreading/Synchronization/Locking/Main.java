package MultiThreading.Synchronization.Locking;

public class Main {
    public static void main(String[] args) {
        BankAcoount sbi = new BankAcoount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "thread-1");
        Thread t2 = new Thread(task, "thead-2");
        t1.start();
        t2.start();
    }
}
