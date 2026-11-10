package tema1.forkJoin.ejemploForkJoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinPool;

public class MiTareaRecursiva extends RecursiveAction {
    private int limite;

    public MiTareaRecursiva(int limite) {
        this.limite = limite;
    }

    @Override
    protected void compute() {
        if (limite <= 10) {
            // Tarea base (suficientemente pequeña)
            System.out.println("Ejecutando directamente: " + limite);
        } else {
            // Dividir en dos subtareas
            MiTareaRecursiva sub1 = new MiTareaRecursiva(limite / 2);
            MiTareaRecursiva sub2 = new MiTareaRecursiva(limite - (limite / 2));

            // Lanzar ambas en paralelo y esperar a que terminen
            ForkJoinTask.invokeAll(sub1, sub2);
        }
    }

    public static void main(String[] args) {
        try (ForkJoinPool pool = new ForkJoinPool()) {
            pool.invoke(new MiTareaRecursiva(40));
        }
    }
}
