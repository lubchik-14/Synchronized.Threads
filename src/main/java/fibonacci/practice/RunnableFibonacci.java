package fibonacci.practice;

import java.math.BigInteger;

public class RunnableFibonacci implements Runnable {
    private BigInteger limit;
    private State state;

    public static class State {
        private BigInteger first = BigInteger.ZERO;
        private BigInteger second = BigInteger.ONE;


        public BigInteger getFirst() {
            return first;
        }

        public BigInteger getSecond() {
            return second;
        }
    }

    public RunnableFibonacci(BigInteger limit) {
        this.limit = limit;
        this.state = new State();
    }

    @Override
    public void run() {
        BigInteger sum;
        int step = 0;
            while (limit.intValue() >= 0) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("Step : %,d\n", step);
                    break;
                }
                sum = state.first.add(state.second);
                state.first = state.second;
                state.second = sum;
                limit = limit.subtract(BigInteger.ONE);
                step++;

        }
    }

    public State getItsState() {
        return state;
    }
}
