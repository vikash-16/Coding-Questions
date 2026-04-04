package MultiThreading.ExecutorFramework;


import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int noOfservices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(noOfservices);
        CyclicBarrier barrier = new CyclicBarrier(noOfservices);
        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));
        System.out.println("main");
        executorService.shutdown();
    }

}

class DependentService2 implements Callable<String> {
    private final CyclicBarrier barrier;

    DependentService2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Service Started...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+ "is waiting at  the barrier");
        barrier.await();
        return "ok";
    }
}
