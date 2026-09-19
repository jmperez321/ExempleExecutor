package ExerciciAlumneExamen;

public class Alumne {
    private String nom;
    private int nota;

    public Alumne(String nom,int nota) {
        this.nom = nom;
    }

    int calcularNota(){
        int nota = (int)(Math.random()*10)+1;
        return nota;
    }

    public int getNota() {
        return nota;
    }
}
