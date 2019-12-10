package fibonacci.practice;

import java.math.BigInteger;

public class FibonacciMain {
    public static void main(String[] args) {
        RunnableFibonacci runnableFibonacci = new RunnableFibonacci(BigInteger.valueOf(5000000));
        Thread runnableThreadFibonacci = new Thread(runnableFibonacci);
        runnableThreadFibonacci.start();
        try {
            Thread.sleep(3000);
            runnableThreadFibonacci.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable\n" + runnableFibonacci.getItsState().getFirst() + "\n" + runnableFibonacci.getItsState().getSecond());
        ThreadFibonacci threadFibonacci = new ThreadFibonacci(BigInteger.valueOf(5000000));
        threadFibonacci.start();
        System.out.println("Start!");
        try {
            Thread.sleep(3000);
            threadFibonacci.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread\n" + threadFibonacci.getItsState().getFirst() + "\n" + threadFibonacci.getItsState().getSecond());
    }
}
