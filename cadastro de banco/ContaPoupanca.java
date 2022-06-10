

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numConta, double saldo) {
        super(numConta, saldo);
    }

    public void infoConta() {
        getNumConta();
        getSaldo();
    }
    

}
