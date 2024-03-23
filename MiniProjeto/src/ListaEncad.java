
import java.util.Scanner;

public class ListaEncad {
    Nó primeiro;
    Disciplina disc;


    public ListaEncad() {
        this.primeiro = null;
    }

    public boolean add(Disciplina disciplina) {
        Nó novoNo = new Nó(disciplina);

        if (primeiro == null) {
            primeiro = novoNo;
            return true;
        }

        Nó atual = primeiro;
        while (atual.prox != null) {
            atual = atual.prox;
        }
        atual.prox = novoNo;

        return true;
    }
    
    public void ordenar() {
        if (primeiro == null || primeiro.prox == null) {
            // Caso a lista esteja vazia ou possua apenas um elemento, não há necessidade de ordenação
            return;
        }

        boolean trocado;
        do {
            Nó atual = primeiro;
            Nó anterior = null;
            trocado = false;

            while (atual.prox != null) {
                // Compara o nome da disciplina atual com o nome da próxima disciplina
                if (atual.disc.getNome().compareToIgnoreCase(atual.prox.disc.getNome()) > 0) {
                    // Troca os nós se estiverem fora de ordem
                    Nó temp = atual.prox;
                    atual.prox = temp.prox;
                    temp.prox = atual;

                    if (anterior == null) {
                        // Se estamos trocando o primeiro nó, atualiza a referência para o novo primeiro nó
                        primeiro = temp;
                    } else {
                        // Atualiza a referência do nó anterior para apontar para o novo nó trocado
                        anterior.prox = temp;
                    }

                    // Atualiza os ponteiros para continuar a ordenação
                    anterior = temp;
                    trocado = true;
                } else {
                    // Move para o próximo nó
                    anterior = atual;
                    atual = atual.prox;
                }
            }
        } while (trocado);
    }

    public Disciplina buscar(String nome) {
        Nó atual = primeiro;
        while (atual != null) {
            if (nome.equalsIgnoreCase(atual.disc.getNome())) {
                // Retorna a disciplina se o nome corresponder
                return atual.disc;
            }
            atual = atual.prox;
        }
        // Retorna null se a disciplina não for encontrada
        return null;
    }

    public void view() {
    	ordenar();
    	Nó atual = primeiro;
        while(atual != null) {
            System.out.print(atual.disc.getNome() + "\n");
            atual = atual.prox;
        }
        System.out.println();
    }
        
    public boolean remove(Disciplina disciplina) {
        if (primeiro == null) {
            return false; // Retorna false se a lista estiver vazia
        }

        // Verifica se a disciplina a ser removida é a primeira da lista
        if (primeiro.disc.equals(disciplina)) {
            primeiro = primeiro.prox; // Atualiza o primeiro nó para o próximo nó
            return true; // Retorna true para indicar que a remoção foi bem-sucedida
        }

        // Caso a disciplina a ser removida não seja a primeira
        Nó atual = primeiro;
        Nó anterior = null;
        while (atual != null && !atual.disc.equals(disciplina)) {
            anterior = atual;
            atual = atual.prox;
        }

        // Se a disciplina foi encontrada na lista, remove-a
        if (atual != null) {
            anterior.prox = atual.prox;
            return true; // Retorna true para indicar que a remoção foi bem-sucedida
        }

        return false; // Retorna false se a disciplina não foi encontrada na lista
    }
    
    public void clear() {
    	primeiro = null;
    }

	public boolean contains(Disciplina disciplina) {
		Nó atual = primeiro;
	    while (atual != null) {
	        if (atual.disc.equals(disciplina)) {
	            return true; // Retorna true se a disciplina for encontrada na lista
	        }
	        atual = atual.prox;
	    }
	    return false; // Retorna false se a disciplina não for encontrada na lista
	}


}

