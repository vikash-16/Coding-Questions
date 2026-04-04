package MultiThreading.ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> "Hello"); // runnable parameter
        System.out.println(future.get()); // blocking call ( null )
        if(future.isDone()){
            System.out.println("Task is done !");
        }
        executorService.shutdown();
    }*/
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable callable = ()-> {
            Thread.sleep(1000);
            System.out.println("Task-1 completed....");
            return 1;
        };
        Callable callable2 = ()-> {
            Thread.sleep(1000);
            System.out.println("task-2 completed...");
            return 2;
        };
        Callable callable3 = ()-> {
            Thread.sleep(1000);
            System.out.println("task -3 completed...");
            return 3;
        };
        List<Callable<Integer>> list = Arrays.asList(callable, callable2, callable3);
        List<Future<Integer>> futures = null;
        try {
            futures = executorService.invokeAll(list,1, TimeUnit.SECONDS);
            futures.forEach(f-> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }catch (CancellationException e) {

                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        boolean shutdown = executorService.isShutdown();
        System.out.println(shutdown);
        System.out.println("hello world");
    }
}
