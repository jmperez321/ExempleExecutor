package concurrencia.wcMixto;

public class Persona extends Thread {
    private String name;
    private int sexo; // 1 hombre, 2 mujer.
    private Lavabo wc;

    public Persona(String name, int sexo, Lavabo wc) {
        this.name = name;
        this.sexo = sexo;
        this.wc = wc;
    }

    @Override
    public void run() {
        try {
            wc.entrarLavabo(sexo);
            String nombreSexo = (sexo == 1) ? "♂" : "♀";
            System.out.println(name + " es " + nombreSexo + " --> baño. ");
            Thread.sleep((long) (Math.random() * 200) + 50);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String nombreSexo = (sexo == 1) ? " ♂ " : " ♀ ";
        System.out.println(name + " es " + nombreSexo + " baño --> ");
        wc.salirLavabo();

    }
}
