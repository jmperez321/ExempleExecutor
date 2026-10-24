package cuentaCo;

import java.util.ArrayList;
import java.util.List;

public class BankApp {
    static void main(String[] args) {
        CuentaCorriente cuentaCo = new CuentaCorriente(1000);
        // 1000 Threads de +10€
        // 1000 Threads de -5€

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thIngress = new Thread(()-> cuentaCo.ingressar(10));
            Thread thTreure = new Thread(()-> cuentaCo.treure(5));
            threads.add(thTreure);
            threads.add(thIngress);

            thIngress.start();
            thTreure.start();

        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.printf("Saldo final : %.2f%n", cuentaCo.getSaldo());
    }

}
