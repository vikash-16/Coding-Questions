package MultiThreading.ExecutorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
//        String string = worker.get();
       /* String hello = worker.getNow("hello"); //doesn't wait
        System.out.println(hello);*/
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(f1, f2);
        voidCompletableFuture.join();
        System.out.println("main completed");
    }
}
