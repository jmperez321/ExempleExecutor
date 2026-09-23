package cursaDeCargols;

public class Cargol implements Runnable{
    private String nom;
    private int metres;

    public Cargol(String nom) {
        this.nom = nom;
        metres = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getMetres() {
        return metres;
    }

    @Override
    public void run() {
        int m = (int) (Math.random()*10+1);
        System.out.println(nom+" ha recorregut "+ m +" metres.");
        metres+=m;
    }
}
