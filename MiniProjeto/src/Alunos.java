public class Alunos {
	
	String RGM;
	String nome;
	public ListaEncad disciplinas;
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
	public boolean adicionarDisciplina(Disciplina disciplina) {
		// Verifica se a lista de disciplinas do aluno não é nula
	    if (this.disciplinas != null) {
	        // Adiciona a disciplina à lista de disciplinas do aluno
	        return this.disciplinas.add(disciplina);
	    } else {
	        return false; // Retorna false se a lista de disciplinas for nula
	    }
	}
	public void mostrarDisciplinas() {
        
		System.out.println("	" );
        disciplinas.view();
    }
	public void removerTodasDisciplinas() {
	    disciplinas.clear();
	}
		public ListaEncad getDisciplinas() {
        return disciplinas;
    }
	public boolean removeDisciplina(Disciplina disciplina) {
	    if (disciplinas != null) {
	        // Chama o método remove da lista encadeada para remover a disciplina
	        disciplinas.remove(disciplina);
	        // Verifica se a disciplina foi removida com sucesso
	        return !disciplinas.contains(disciplina);
	    }
	    return false; // Retorna false se a lista de disciplinas for nula
	}
	public Disciplina buscarDisciplina(String nome) {
		// Verifica se a lista de disciplinas não é nula
		if (this.disciplinas != null) {
			// Chama o método buscar() da lista encadeada de disciplinas para encontrar a disciplina pelo nome
		    return this.disciplinas.buscar(nome);
		} else {
		    return null; // Retorna null se a lista de disciplinas for nula
		}
	}	
	
	
}
