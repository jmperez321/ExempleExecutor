package ExerciciAlumneExamen;

import java.util.ArrayList;
import java.util.List;

public class Examinar {
    static void main(String[] args) {
        int alumMAX = 20;
        List<Alumne> alumnes = new ArrayList<>();
        for (int i = 0; i < alumMAX; i++) {
            Alumne a = new Alumne("alum"+i, (int)(Math.random()*10));
        }

        List<Integer> notes = new ArrayList<>();
        for (int i = 0; i < alumnes.size(); i++) {
            notes.add(alumnes.get(i).calcularNota());
        }
        for (int i = 0; i <notes.size(); i++) {
            System.out.println("L'alumne " + alumnes.get(i) + "ha tret un " + notes.get(i));
        }
    }
}
