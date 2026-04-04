package Synchronization;
class Table3 {
    synchronized static void printTable(int n) {
        /*for(int i = 1; i <= 10; i++) {
            System.out.println(n*i);
            try {
                Thread.sleep(400);
            }catch (Exception e) {

            }
        }*/
        for(int i = 1; i <=2; i++) {
            System.out.println(n*i);
        }
        System.out.println(Thread.currentThread().getName()+ "completed"+"\n");
    }
}
class MyStaticThread1 extends Thread {
    @Override
    public void run() {
        Table3.printTable(1);
    }
}
class MyStaticThread2 extends Thread {
    MyStaticThread1 m1;

    public MyStaticThread2(MyStaticThread1 t1) {
        this.m1 = t1;
    }

    @Override
    public void run() {
        try {
            m1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Table3.printTable(10);
    }
}

class MyStaticThread3 extends Thread {
    MyStaticThread2 m2;
    public MyStaticThread3(MyStaticThread2 t2) {
        this.m2 = t2;
    }

    @Override
    public void run() {
        try {
            m2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Table3.printTable(100);
    }
}

class MyStaticThread4 extends Thread {
    MyStaticThread3 m3;
    public MyStaticThread4(MyStaticThread3 t3) {
        this.m3 = t3;
    }

    @Override
    public void run() {
        try {
            m3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Table3.printTable(1000);
    }
}
public class Static_Synchronization_Example {
    public static void main(String[] args) {
        MyStaticThread1 t1 = new MyStaticThread1();
        MyStaticThread2 t2 = new MyStaticThread2(t1);
        MyStaticThread3 t3 = new MyStaticThread3(t2);
        MyStaticThread4 t4 = new MyStaticThread4(t3);
        t1.start();
//            t1.join();
        t2.start();
//            t2.join();
        t3.start();
//            t3.join();
        t4.start();
//            t4.join();
    }
}
