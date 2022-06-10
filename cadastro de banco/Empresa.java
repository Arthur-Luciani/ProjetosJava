

public class Empresa implements InfoConta {
    private String nomeDaEmpresa, cnpj;
    private Conta conta;

    public Empresa(String nomeDaEmpresa, String cnpj) {
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.cnpj = cnpj;
    }

    public Conta getConta() {
		return conta;
	}
    
    public void addConta(Conta conta) {
		this.conta = conta;
	}

    

    public void imprimirInfoConta() {
        System.out.println("INFORMAÇÕES DA CONTA CORRENTE");
        System.out.println("NÚMERO DA CONTA:"+getConta().getNumConta());
        System.out.println("SALDO:"+getConta().getSaldo());
        System.out.println("NOME: "+nomeDaEmpresa);
        System.out.println("CNPJ: "+cnpj);
    }
    

}
