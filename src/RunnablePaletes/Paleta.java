package RunnablePaletes;

public class Paleta implements Runnable{

    private String nom;
    public Paleta(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        System.out.println(getNom()+" Empieza");
        try {
            Thread.sleep((int) Math.random());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        System.out.println(getNom()+" Terminado");
    }

}
