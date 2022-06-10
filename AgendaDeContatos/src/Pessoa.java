
public class Pessoa {
	private String id;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private int sexo;
	private String testePreenchimento="";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public boolean pessoaVazia() {
		if (getId().equals("    ") || getNome().equals("                                      ")|| getEndereco().equals(testePreenchimento)|| getEmail().equals(testePreenchimento)|| getTelefone().equals("(  )     -    ") ) {
			return true;
		}else {
			return false;
		}
	}

}
