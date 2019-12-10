package point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizedMovingPoint {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Point myPoint = new Point();
        myPoint.addObserver(new PointConsoleObserver());
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            futureList.add(service.submit(() -> myPoint.move(1, 1)));
        }

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occurred getting future");
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.err.println("ExecutionException occurred getting future");
                e.printStackTrace();
            }
        });
        System.out.printf("Point[%s:%s]\n", myPoint.getX(), myPoint.getY());
        service.shutdown();
    }
}
