

public class Aluno extends Pessoa implements InfoConta {
    private int matricula;

    public Aluno(String nome, String cpf, int idade, int matricula) {
        super(nome, cpf, idade);
        this.matricula = matricula;
    }

    public void infoPessoa() {
        System.out.println("Nome: "+getNome());
        System.out.println("Idade: "+getIdade()+" anos");
        System.out.println("Profissão: Estudante");
        System.out.println("Matrícula: "+matricula);        
    }

    public void imprimirInfoConta() {
        System.out.println("INFORMAÇÃO DETALHADA DA CONTA POUPANÇA");
        System.out.println("NÚMERO DA CONTA: "+getConta().getNumConta());
        System.out.println("VARIAÇÃO: 51");
        System.out.println("SALDO: "+getConta().getSaldo());
        System.out.println("NOME TITULAR: "+getNome());
        System.out.println("CPF: "+getCpf());
    }
    


}
