package s2.pract;

// soluciona el problema de fer una divisio a resta fent us de forkjoin pool
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Div extends RecursiveTask<Long> {
    private int n;
    private int d;

    public Div(int n, int d) {
        this.n = n;
        this.d = d;
    }

    @Override
    protected Long compute() {
        if (n < 100) return DivS();
        else return DivR();

    }

    private Long DivR() {
        System.out.println("DivR: n = " + n + ", d = " + d);
        Div div1 = new Div(n - d, d);
        div1.fork();
        return div1.join() + 1;
    }

    private Long DivS() {
        System.out.println("DivS: n = " + n + ", d = " + d);
        long temp = n;
        long count = 0;

        while (temp >= d) {
            temp -= d;
            count++;
        }
        System.out.println("Resultado parcial: " + count);

        return count;
    }

    static void main() {
        ForkJoinPool pool = new ForkJoinPool();
        Long res = pool.invoke(new Div(200, 30));

        System.out.println("Resultado: " + res);
        pool.close();
    }
}
