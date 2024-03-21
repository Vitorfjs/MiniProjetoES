

public class ListaSeq {
		
		final int MAX = 60;
		Alunos[] alunos = new Alunos[MAX];
		ListaEncad listaEncad = new ListaEncad();
		int n = 0;
		
		public boolean estaVazia() {
			return (n == 0);
		}
		
		public boolean estaCheia() {
			return (n == alunos.length);
		}
		
		public int tamanhoLista() {
			return n;
		}
		
		public Alunos Buscar(String nome) {
			int left = 0;
			int right = n - 1;
			
			while(left <= right) {
				int meio = left + (right - left)/2;
				
				// Verifica se o nome está no meio
				int comparacao = alunos[meio].nome.compareTo(nome);
				if (comparacao == 0){
					return alunos[meio];
				}
				
				// Se o nome estver à esquerda, atualiza o limite direito
				if (comparacao < 0) {
					left = meio + 1;
				// Se o nome estver à direita, atualiza o limite esquerdo	
				} else {
					right = meio - 1;
				}
			}
			return null;
			
		}
		
		public Alunos BuscarSeq(int pos) {
		    // Verifica se a variável posição encontrada é válida
		    if (pos >= 0 && pos < n) {
		        return alunos[pos];
		    } 
		    return null;
		}

		
		public boolean compara(Alunos c1, Alunos c2) {
			return (c1.nome.equals(c2.nome)); //&&
//					(c1.numero.equals(c2.numero));
		}
		
		public int returnPosicao(Alunos contato) {
			for (int i = 0; i < n; i++) {
				if (compara(alunos[i], contato)) {
					return i;
				}
			}
			
			return -1;
		}

		public void moveDireita(int pos) {
			for (int i = n; i > pos; i--) {
				alunos[i] = alunos[i -1];
				
			}
		}
		
		public boolean insertContato(int pos, Alunos c1) {
			if (estaCheia() || (pos > n) || (pos < 0)) {
				return false;
			}
			
			moveDireita(pos);
			alunos[pos] = c1;
			n++;
			return true;
		}
		
		public void moveEsquerda(int pos) {
			for (int i = pos; i < (n -1); i++) {
				alunos[i] = alunos[i+1];
			}
		}
		
		public boolean remove(Alunos contato) {
		    int pos = returnPosicao(contato);
		    if (pos == -1) {
		        return false; // O contato não está na lista, portanto não podemos removê-lo
		    }
		    
		    moveEsquerda(pos);
		    n--;
		    return true; // Remoção bem-sucedida
		}
		
		public void showList() {
			
			for (int i = 0; i < n; i++) {
				System.out.println(" " + (i+1) + " - " +"" + alunos[i].RGM + " | " 
				+ "" + alunos[i].nome );
				alunos[i].mostrarDisciplinas();
				System.out.println();
				
			}
			System.out.println("\nTotal: " + n);
		}
		
		public void ordenar() {
			
			for (int i = 1; i < n; i++) {
				Alunos chave = alunos[i];
	            int j = i - 1;

	            // Move os elementos maiores que a chave uma posição à frente
	            while (j >= 0 && alunos[j].RGM.compareTo(chave.RGM) > 0) {
	            	alunos[j + 1] = alunos[j];
	                j--;
	            }
	            alunos[j + 1] = chave;
	        }
		}
			
}	
		
