package tallerCostura;

public class Main {
    static void main(String[] args) {
        Cistell manigues = new Cistell(8);
        Cistell cossos = new Cistell(5);

        CosidoraDeCossos cosDeCos = new CosidoraDeCossos(cossos);
        CosidoraDeManigues cosDeMan = new CosidoraDeManigues(manigues);

        Encadellador encadellador = new Encadellador(manigues,cossos);

        cosDeMan.start();
        cosDeCos.start();
        encadellador.start();



    }
}
