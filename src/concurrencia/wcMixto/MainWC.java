package concurrencia.wcMixto;

public class MainWC {
    static void main(String[] args) {
        Lavabo wc = new Lavabo();
        Persona p1 = new Persona("Pau",1,wc);
        Persona p2 = new Persona("Alex",1,wc);
        Persona p3 = new Persona("Tao",1,wc);
        Persona p4 = new Persona("Joana",2, wc);
        Persona p5 = new Persona("Lyanna",2, wc);
        Persona p6 = new Persona("Eva",2, wc);
        Persona p7 = new Persona("Adan",1, wc);
        Persona p8 = new Persona("Siria",2, wc);
        Persona p9 = new Persona("Daniel",1, wc);
        Persona p10 = new Persona("Monica",2, wc);

        System.out.println("--- EMPIEZA LA SIMULACIÓN DEL WC ---");

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        p10.start();

    }
}
