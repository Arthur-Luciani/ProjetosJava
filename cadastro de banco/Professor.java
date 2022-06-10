

public class Professor extends Pessoa implements InfoConta {
    private String disciplina;

    public Professor(String nome, String cpf, String disciplina, int idade) {
        super(nome, cpf, idade);
        this.disciplina = disciplina;
    }

    public void infoPessoa() {
    System.out.println("Nome: "+getNome());
    System.out.println("Idade: "+getIdade()+" anos");
    System.out.println("Profissão: Professor de "+disciplina);
    }

    public void imprimirInfoConta() {
        System.out.println("INFORMAÇÕES DA CONTA CORRENTE");
        System.out.println("NÚMERO DA CONTA: "+getConta().getNumConta());
        System.out.println("SALDO: "+getConta().getSaldo());
        System.out.println("NOME TITULAR: "+getNome());
        System.out.println("CPF TITULAR: "+getCpf());
    }
}
