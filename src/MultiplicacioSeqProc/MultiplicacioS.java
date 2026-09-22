package MultiplicacioSeqProc;

public class MultiplicacioS {
    private int operador1;
    private int operador2;
    public MultiplicacioS(int operador1, int operador2) {
        this.operador1 = operador1;
        this.operador2 = operador2;
    }
    public int multiplicar(){
        return operador1*operador2;
    }
}
