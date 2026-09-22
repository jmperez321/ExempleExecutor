package ExerciciAlumneExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExamenP {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<AlumneP> alumneList = new ArrayList<AlumneP>();
        for (int i = 0; i < 25; i++) {
            AlumneP a = new AlumneP("Alumne-" + i);
            alumneList.add(a);
        }

        List<Future<Integer>> notes;

        notes = executor.invokeAll(alumneList);
        executor.shutdown();

        for(int i = 0; i < notes.size(); i++) {
            Future<Integer> resultat = notes.get(i);
            System.out.printf("%s ha tret un %d%n", alumneList.get(i).getNom(),resultat.get());
        }
    }
}
