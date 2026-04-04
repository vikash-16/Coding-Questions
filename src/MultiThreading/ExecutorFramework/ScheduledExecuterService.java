package MultiThreading.ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuterService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
/*
        scheduledExecutorService.schedule(()-> System.out.println("hello"),1, TimeUnit.SECONDS);
*/
        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("task executed after every 5 sec"),
                5,
                5,
                TimeUnit.SECONDS
        );
        ScheduledFuture<?> initiatingShutdown = scheduledExecutorService.schedule(
                () -> {
                    System.out.println("initiating shutdown");
                    scheduledExecutorService.shutdown();
                },
                5,
                TimeUnit.SECONDS
        );
    }
}
