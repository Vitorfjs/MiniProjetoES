
import java.util.Scanner;

public class ListaEncad {
    Nó primeiro;
    Disciplina disc;


    public ListaEncad() {
        this.primeiro = null;
    }

    public boolean add(String nome) {
        Nó novoNo = new Nó(nome);

        // Caso especial: lista vazia ou novo nó vem antes do primeiro nó
        if (primeiro == null || nome.compareToIgnoreCase(primeiro.disc.getNome()) < 0) {
            novoNo.prox = primeiro;
            primeiro = novoNo;
            return true;
        }

        Nó anterior = primeiro;
        Nó atual = primeiro.prox;

        // Encontra a posição correta para inserir o novo nó
        while (atual != null && nome.compareToIgnoreCase(atual.disc.getNome()) >= 0) {
            anterior = atual;
            atual = atual.prox;
        }

        // Insere o novo nó na posição correta
        novoNo.prox = atual.prox;
        anterior.prox = novoNo;

        return true;
    }

    public void buscar() {
    	Nó atual = primeiro;
        boolean foi = false;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Disciplina que deseja buscar: ");
        String nome = scan.nextLine();
        
        while (atual != null) {
            if(nome.equalsIgnoreCase(atual.disc.getNome())){
                System.out.println("Disciplina: " + atual.disc.getNome());
                foi = true;
            }
            atual = atual.prox;
        }
        if(foi == false) {
            System.out.println("Disciplina não encontrada");
        }
        
        scan.close();

    }

    public void view() {
    	Nó atual = primeiro;
        while(atual != null) {
            System.out.print(atual.disc.getNome() + "\n");
            atual = atual.prox;
        }
        System.out.println();
    }
        
    public void remove() {
    	
    	 // Verifica se a lista está vazia
        if (primeiro == null) {
            return;
        }
        
        Nó atual = primeiro;
        Nó anterior = null;
    	boolean foi = false;
    	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.print("Nome que deseja buscar: ");
    	String nome = scan.nextLine();
    	
    	while(atual != null) {
    		if(nome.equalsIgnoreCase(atual.disc.getNome())) {
    			System.out.println("Nome encontrado: " + atual.disc.getNome());
    			foi = true;
    			// Remove o nó encontrado da lista
                if (anterior != null) {
                    // Se o nó encontrado não é o primeiro da lista
                    anterior.prox = atual.prox; // agr o nó anterior ao que está sendo removido, aponta para o referencial (.prox) do que está sendo removido, que no caso esse .prox do que está sendo removido, aponta para o nó seguinte a ele
                } else {
                    // Se o nó encontrado é o primeiro da lista
                    primeiro = atual.prox;
                }
                // Libera a memória do nó removido (se necessário)
                // Não implementado aqui, pode ser necessário dependendo da linguagem
                break; // Interrompe o loop após encontrar e remover o nó
            }
            // Atualiza as referências para continuar percorrendo a lista
            anterior = atual;
            atual = atual.prox;
    	}
    	if(foi == false) {
    		System.out.println("Nome inválido");
    		
    	}
    }


}

