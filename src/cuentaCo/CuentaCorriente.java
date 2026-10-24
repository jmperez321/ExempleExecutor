package cuentaCo;

public class CuentaCorriente {

    private float saldo;
    public CuentaCorriente(float saldo) {
        this.saldo = saldo;
    }
    public synchronized void ingressar(float diners) {
        float aux;
        aux=getSaldo();
        aux=aux+diners;
        saldo=aux;
        setSaldo(saldo);
    }

    public synchronized void treure(float diners) {
        float aux;
        aux=getSaldo();
        aux=aux-diners;
        saldo=aux;
        setSaldo(saldo);
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
