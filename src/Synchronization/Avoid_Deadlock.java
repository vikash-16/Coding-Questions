package Synchronization;

public class Avoid_Deadlock {
    private class Resource1 {
        private int i = 10;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
    private class Resource2 {
        private int j = 20;

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }
    public static void main(String[] args) {
        Avoid_Deadlock avoidDeadlock = new Avoid_Deadlock();
        Resource1 resource1 = avoidDeadlock.new Resource1();
        Resource2 resource2 = avoidDeadlock.new Resource2();
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 : resource 1");
                /*try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                synchronized (resource2) {
                    System.out.println("Thread 1 : Resource 2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 : resource 2");
                synchronized (resource1) {
                    System.out.println("Thread 2 : resource 2");
                }
            }
        });
        t1.start();
        t2.start();
    }

}
