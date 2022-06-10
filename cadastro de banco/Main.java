
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		Aluno aluno = new Aluno("João","222.333.444-55",21,12345);	
		aluno.addConta(new ContaPoupanca(112233,500));

		Professor professor = new Professor("Pedro", "111.111.111-00", "Matemática", 35);
		professor.addConta(new ContaCorrente(123456,5000));

		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		listaPessoas.add(professor);
		listaPessoas.add(aluno);

		for (Pessoa pessoa : listaPessoas) {
			pessoa.infoPessoa();
			System.out.println();
		}

		Empresa hering = new Empresa("CIA HERING", "78.876.950/0001-71");
		hering.addConta(new ContaCorrente(33333,50000));

		ArrayList<InfoConta> listaContas = new ArrayList<InfoConta>();
		listaContas.add(aluno);
		listaContas.add(professor);
		listaContas.add(hering);
			
		for (InfoConta infoConta : listaContas) {
			infoConta.imprimirInfoConta();
			System.out.println();
		}

	}
	
}

//SAIDA ESPERADA
//Nome: Pedro
//Idade: 35 anos
//Profissão: Professor de Matemática
//
//Nome: João
//Idade: 21 anos
//Profissão: Estudante
//Matrícula: 12345
//
//INFORMAÇÃO DETALHADA DA CONTA POUPANÇA
//NÚMERO DA CONTA: 112233
//VARIAÇÃO: 51
//SALDO: 500.0
//NOME TITULAR: João
//CPF: 222.333.444-55
//
//INFORMAÇÕES DA CONTA CORRENTE
//NÚMERO DA CONTA: 123456
//SALDO: 5000.0
//NOME TITULAR: Pedro
//CPF TITULAR: 111.111.111-00
//
//INFORMAÇÕES DA CONTA CORRENTE
//NÚMERO DA CONTA: 33333
//SALDO: 50000.0
//NOME: CIA HERING
//CNPJ: 78.876.950/0001-71

