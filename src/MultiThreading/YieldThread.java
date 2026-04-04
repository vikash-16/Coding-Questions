package MultiThreading;

public class YieldThread extends Thread{
    YieldThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ "-is Running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldThread a = new YieldThread("First Thread");
        YieldThread b = new YieldThread("Second Thread");
        a.start();
        b.start();
    }
}
/* Withoud Yield
*
* First Thread-is Running
First Thread-is Running
First Thread-is Running
First Thread-is Running
First Thread-is Running
Second Thread-is Running
Second Thread-is Running
Second Thread-is Running
Second Thread-is Running
Second Thread-is Running*/


/*Withoud Yield
*
* First Thread-is Running
Second Thread-is Running
First Thread-is Running
First Thread-is Running
First Thread-is Running
First Thread-is Running
Second Thread-is Running
Second Thread-is Running
Second Thread-is Running
Second Thread-is Running*/


