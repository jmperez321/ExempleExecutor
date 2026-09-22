package ExerciciAlumneExamen;

import java.util.concurrent.Callable;

public class AlumneP implements Callable<Integer> {
    private String nom;
    public AlumneP(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int examinar() {
        return (int)(Math.random() * 10);
    }

    @Override
    public Integer call() throws Exception {
        return examinar();
    }
}
