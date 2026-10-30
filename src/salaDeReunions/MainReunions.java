package salaDeReunions;


public class MainReunions {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();
        SalaReunions salaReunions = new SalaReunions(3); // Capacitat màxima de 3 persones

        for (int i = 0; i < 5; i++) {
            new Usuari(impressora, salaReunions).start();
        }
    }
}