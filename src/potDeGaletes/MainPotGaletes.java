package potDeGaletes;

public class MainPotGaletes {
    static void main(String[] args) {
        Pot pg = new Pot();
        Fill f1 = new Fill("Joanet",pg);
        Fill f2 = new Fill("Joanic",pg);

        Pare p = new Pare("Joan", pg);

        p.start();
        f1.start();
        f2.start();


    }
}
