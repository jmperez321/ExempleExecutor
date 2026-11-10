package tema1.ciutatMagica;

public class ciutatMagicaMain {
    static void main(String[] args) {
        Clau c = new Clau();
        Guardia g = new Guardia(c);
        Profecia p = new Profecia(c,g);

        g.start();
        p.start();

    }
}
