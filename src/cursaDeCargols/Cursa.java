package cursaDeCargols;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cursa {
    static void main() throws InterruptedException {

        Cargol treubanya = new Cargol("Treubanya");
        Cargol melon = new Cargol("Melonicus");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(treubanya,3,2, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(melon,5,1, TimeUnit.SECONDS);
        executor.awaitTermination(15,TimeUnit.SECONDS);
        executor.shutdown();

        if (treubanya.getMetres()> melon.getMetres()){
            System.out.println("El Cargol "+ treubanya.getNom()+" ha guanyat amb "+ treubanya.getMetres()+" metres.");

        }else {
            System.out.println("El Cargol "+ melon.getNom()+" ha guanyat amb "+ melon.getMetres()+" metres.");
        }
        System.out.println("Distancia recorreguda:\n"+treubanya.getNom() + " " + treubanya.getMetres()+"\n"+ melon.getNom()  + " " + melon.getMetres());
    }

}
