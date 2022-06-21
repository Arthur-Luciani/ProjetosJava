import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atualizacao extends Paciente {
	private LocalDate dataAtualizacao;
	private float pesoAtualizacao, alturaAtuazalicao;
	
	public String getDataAtualizacao() {
		
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String dataAtualizacaoStr = dataAtualizacao.format(formatacao);		
		return dataAtualizacaoStr;
	}
	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public float getPesoAtualizacao() {
		return pesoAtualizacao;
	}
	public void setPesoAtualizacao(float pesoAtualizacao) {
		this.pesoAtualizacao = pesoAtualizacao;
	}
	public float getAlturaAtuazalicao() {
		return alturaAtuazalicao;
	}
	public void setAlturaAtuazalicao(float alturaAtuazalicao) {
		this.alturaAtuazalicao = alturaAtuazalicao;
	}
}
