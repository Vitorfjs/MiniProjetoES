public class Alunos {
	
	String RGM;
	String nome;
	private ListaEncad disciplinas;
	//String numero;
	
	public Alunos(String RGM, String nome) {
	
		this.nome = nome;
		this.RGM = RGM;
		this.disciplinas = new ListaEncad();
		
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
	public String getRGM() {
		return RGM;
	}
	public void setRGM(String RGM) {
		this.RGM = RGM;
	}
	public void adicionarDisciplina(String disciplina) {
        disciplinas.add(disciplina);
    }
	public void mostrarDisciplinas() {
        
		System.out.println("	" );
        disciplinas.view();
    }
}
