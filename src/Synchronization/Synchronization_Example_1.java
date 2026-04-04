package Synchronization;

import java.util.HashSet;

/*In this example, there is no synchronization, so output is inconsistent. Let's see the example:*/
class Table {
    void printTable(int n) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(n*i);
        }
        try {
            Thread.sleep(500);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}
class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}
public class Synchronization_Example_1 {
    public static void main(String[] args) {
        Table table = new Table();
        MyThread1 myThread1 = new MyThread1(table);
        MyThread2 myThread2 = new MyThread2(table);
        myThread1.start();
        myThread2.start();

//        HashSet
    }
}
