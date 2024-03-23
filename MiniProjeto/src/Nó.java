
public class Nó {
    Disciplina disc;
    Nó prox;

    public Nó(String nome) {
        this.disc = new Disciplina(nome);
        this.prox = null;
    }
    
    public Nó(Disciplina disc) {
        this.disc = disc;
        this.prox = null;
    }
}
