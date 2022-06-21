import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Paciente implements Serializable {
	
	private static final long serialVersionUID= 1L;

	private String nome, dataDeNascimento, situacaoImc;
	private float peso, altura, imc;
	private int idade;
	private LocalDate dataDeNascimentoLD, dataatualLD=LocalDate.now();
	private ArrayList<Atualizacao>listaAtualizacao = new ArrayList<Atualizacao>();
	
	public ArrayList<Atualizacao> getListaAtualizacao() {
		return listaAtualizacao;
	}
	public void setListaAtualizacao(ArrayList<Atualizacao> listaAtualizacao) {
		this.listaAtualizacao = listaAtualizacao;
	}
	public int getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
		setIdade();
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public void setIdade() {
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataDeNascimentoLD = LocalDate.parse(dataDeNascimento, formatacao);
		idade = Period.between(dataDeNascimentoLD, dataatualLD).getYears();
	}
	public float imc(float peso, float altura) {
		imc= (peso)/(altura*altura);
		return imc;
	}
	public String situacaoImc() {
		if (imc<17) {
			situacaoImc="Muito abaixo do peso";
		}else if (imc>=17 && imc <18.5) {
			situacaoImc="Abaixo do peso";
		}else if (imc>=18.5 && imc<25) {
			situacaoImc="Peso normal";
		}else if (imc>=25 && imc<30) {
			situacaoImc="Acima do peso";
		}else if (imc>=30 && imc<35) {
			situacaoImc="Obesidade I";
		}else if (imc>=35 && imc<40) {
			situacaoImc="Obesidade II (severa)";
		}else {
			situacaoImc="Obesidade III (mórbida)";
		}
		return situacaoImc;
	}

	
	
	public void addAtualizacao(Atualizacao d) {
		listaAtualizacao.add(d);
	}

}
