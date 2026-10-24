package tallerCostura;

public class CosidoraDeManigues extends Thread{
    Cistell cisManigues;


    public CosidoraDeManigues(Cistell tipus) {
        this.cisManigues = tipus;
    }
    @Override
    public void run(){
        for(;;){
            try {
                cisManigues.afegir();
                System.out.println("La cosidora de Manigues ha ficat +1 Maniga al Cistell de Manigues");
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
