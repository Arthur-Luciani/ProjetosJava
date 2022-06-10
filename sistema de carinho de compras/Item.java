

public class Item {
	public double valor;
	public String nome;

	public Item(double valor, String nome) {
		this.valor=valor;
		this.nome=nome;
	}
	// Possui dois atributos: o valor e o nome
	public void setValor(double item) {
		this.valor=item;
	}
	public void setNome(String item) {
		this.nome=item;
	}
	public double getValor(){
		return valor;
	}
	public String getNome(){
		return nome;
	}
}