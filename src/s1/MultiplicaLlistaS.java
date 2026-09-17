package s1;

import java.util.ArrayList;
import java.util.List;

public class MultiplicaLlistaS {
    static void main() {
        List<MultiplicacioS> llista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultiplicacioS m = new MultiplicacioS((int)(Math.random()*10), (int)(Math.random()*10));
            llista.add(m);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < llista.size(); i++) {
            res.add(llista.get(i).multiplicar());
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println("Resultat tasca "+i+" és: "+res.get(i));
        }
    }
}
