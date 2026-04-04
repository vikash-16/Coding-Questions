package Synchronization;

/**
Java Synchronized Method:
If you declare any method as synchronized, it is known as synchronized method.

Synchronized method is used to lock an object for any shared resource.

When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
*/
class Table2 {
    synchronized void printTable(int n) {                       /*Synchronized Method*/
//        synchronized (this) {                 /*Synchronized block*/
            for (int i = 1; i <= 100; i++) {
                System.out.println(n * i);
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
//    }
}
class MyThread_1 extends Thread {
    Table2 t;
    MyThread_1(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}
class MyThread_2 extends Thread {
    Table2 t;
    MyThread_2(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}
public class Java_Synchronized_Method_Example {
    public static void main(String[] args) {
        Table2 table2 = new Table2();
        MyThread_1 myThread1 = new MyThread_1(table2);
        MyThread_2 myThread2 = new MyThread_2(table2);
        myThread1.start();
        myThread2.start();
    }
}
