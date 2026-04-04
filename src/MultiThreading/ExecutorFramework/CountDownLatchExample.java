package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> f1 = executorService.submit(new DependentService());
        Future<String> f2 = executorService.submit(new DependentService());
        Future<String> f3 = executorService.submit(new DependentService());
        f1.get();
        f2.get();
        f3.get();
        System.out.println("all dependent service finished. starting main service....");
        executorService.shutdown();*/
        int noOfservices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(noOfservices);
        CountDownLatch countDownLatch = new CountDownLatch(noOfservices);
        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
        countDownLatch.await();
        System.out.println("main");
        executorService.shutdown();

    }

}
class DependentService implements Callable<String> {
    private final CountDownLatch countDownLatch;
    DependentService(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " Service Started...");
            Thread.sleep(1000);
        }finally {
            countDownLatch.countDown();
        }
        return "ok";
    }
}
