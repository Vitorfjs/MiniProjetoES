public class Alunos {
	
	String RGM;
	String nome;
	//String numero;
	
	public Alunos(String ddd, String nome) {
	
		this.nome = nome;
		this.RGM = ddd;
		//this.numero = numero;
		
	}
	public Alunos() {
		// TODO Auto-generated constructor stub
		// Construtor criado apenas para criação dos objetos na main
		// Por padrão é necessário
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDdd() {
		return RGM;
	}
	public void setDdd(String ddd) {
		this.RGM = ddd;
	}
//	public String getNumero() {
//		return numero;
//	}
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
	
}
