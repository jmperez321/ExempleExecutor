package concurrencia.wcMixto;

public class Lavabo {
    private int MAX = 3;
    private int gente = 0;
    private int sexoLavabo = 0; // 0 vacio, 1 hombre, 2 mujer.

    // Nuevas variables para evitar la inanición
    private int hombresEsperando = 0;
    private int mujeresEsperando = 0;

    public Lavabo() {
    }

    public synchronized void entrarLavabo(int sexo) throws InterruptedException {
        // FASE 1: Llego y me pongo en la cola
        if (sexo == 1) {
            hombresEsperando++;
        } else {
            mujeresEsperando++;
        }

        // Variable de ayuda para saber si hay gente del sexo contrario esperando
        boolean elOtroSexoEspera = (sexo == 1) ? (mujeresEsperando > 0) : (hombresEsperando > 0);

        // FASE 2: Evalúo si debo esperar
        while (gente == MAX || (gente > 0 && sexoLavabo != sexo) || (gente > 0 && elOtroSexoEspera)) {
            wait();
        }

        // FASE 3: Logré pasar. Salgo de la cola y entro al baño.
        if (sexo == 1) {
            hombresEsperando--;
        } else {
            mujeresEsperando--;
        }

        gente++;
        this.sexoLavabo = sexo;
    }

    public synchronized void salirLavabo() {
        gente--;
        if (gente == 0) {
            sexoLavabo = 0;
        }
        notifyAll();
    }
}