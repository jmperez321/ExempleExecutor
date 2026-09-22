package RunnablePaletes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pared {
    static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Paleta> paletaList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Paleta p = new Paleta("Paleta"+i);
            paletaList.add(p);
        }

        for (int i = 0; i < paletaList.size(); i++) {
            executor.execute(paletaList.get(i));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

    }



}
