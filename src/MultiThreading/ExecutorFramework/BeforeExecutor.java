package MultiThreading.ExecutorFramework;

public class BeforeExecutor {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long factorial = factorial(finalI);
                        System.out.println(factorial);
                    }
            );
            threads[i-1].start();
        }
        for (Thread thread: threads ) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("total time "+ (System.currentTimeMillis()-startTime));

    }

    public static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


/*
* In above example above code taking 9sec when thread will not use
* when thread use then it will take only 1 sec but here problem is that we have to define every thing like create thread, joining thread ...etc.
* to overcome above issue executore will come into picture*/