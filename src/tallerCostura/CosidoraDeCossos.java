package tallerCostura;

public class CosidoraDeCossos extends Thread {
    Cistell cisCossos;


    public CosidoraDeCossos(Cistell tipus) {
        this.cisCossos = tipus;
    }
    @Override
    public void run(){
        for(;;){
            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                cisCossos.afegir();
                System.out.println("La cosidora de Cossos ha ficat +1 Cos al Cistell de Cossos");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
