package MultiThreading.Synchronization;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("");
        }
        System.out.println(counter.getCount());
    }
}
/*
* count should be 2000 but you dont get 2000 as because 2 threads accessing the same value of count and increament that why your are getting different count*/

/*When you add Synchronized in method level or block level then only one thread can access it*/