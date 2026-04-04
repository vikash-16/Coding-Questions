package MultiThreading;
/* Thread Priority method Scenario*/
public class MyThread extends Thread{
    MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            String a = "";
            for(int j = 0; j < 1000; j++) {
                a+="";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - Count:" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        MyThread l = new MyThread("Low Priority Thread");
        MyThread m = new MyThread("Medium Priority Thread");
        MyThread h = new MyThread("High Priority Thread");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}

/*
*
* Medium Priority Thread - Priority: 5 - Count:0
Low Priority Thread - Priority: 1 - Count:0
High Priority Thread - Priority: 10 - Count:0
Low Priority Thread - Priority: 1 - Count:1
Medium Priority Thread - Priority: 5 - Count:1
High Priority Thread - Priority: 10 - Count:1
High Priority Thread - Priority: 10 - Count:2
Medium Priority Thread - Priority: 5 - Count:2
Low Priority Thread - Priority: 1 - Count:2
Low Priority Thread - Priority: 1 - Count:3
Medium Priority Thread - Priority: 5 - Count:3
High Priority Thread - Priority: 10 - Count:3
Medium Priority Thread - Priority: 5 - Count:4
High Priority Thread - Priority: 10 - Count:4
Low Priority Thread - Priority: 1 - Count:4
*/
