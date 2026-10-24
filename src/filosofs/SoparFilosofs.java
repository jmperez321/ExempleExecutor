package filosofs;

public class SoparFilosofs {
    static void main(String[] args) {

        Cobert c1 = new Cobert();
        Cobert c2 = new Cobert();
        Cobert c3 = new Cobert();
        Cobert c4 = new Cobert();


        Filosof f1 = new Filosof("Melon", c1, c2);
        Filosof f2 = new Filosof("Sandia", c2, c3);
        Filosof f3 = new Filosof("Melocton", c3, c4);
        Filosof f4 = new Filosof("Pau", c4, c1);

        f1.start();
        f2.start();
        f3.start();
        f4.start();


    }
}
