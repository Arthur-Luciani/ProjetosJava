
public abstract class Conta {
	
	private double saldo;
	private int numConta;

	public Conta(int numConta, double saldo) {
		this.numConta = numConta;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public abstract void infoConta();
	
}

