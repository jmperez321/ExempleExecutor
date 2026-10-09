package s2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n < 10) return FibS();
        else return FibR();
    }

    private Long FibR() {
        System.out.printf("req %d \n", n);
        FibonacciTask t1 = new FibonacciTask(n - 1);
        FibonacciTask t2 = new FibonacciTask(n - 2);
        invokeAll(t1, t2);
        return t1.join() + t2.join();
    }

    private Long FibS() {
        System.out.printf("seq %d \n", n);
        long prev1 = 0, prev2 = 1;
        for (int i = 0; i < n; i++) {
            long savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    static void main() {
        int n = 25;
        FibonacciTask task = new FibonacciTask(n);
        ForkJoinPool pool = new ForkJoinPool();

        pool.submit(task);

        long result = task.join();
        System.out.printf("El Fibonacci de %d és %d%n", n, result);
    }
}