class Pilha {

	private Jogador[] pilha;
	private int topo;
	
	
	//Construtor 1: Com parâmetro
	public Pilha(int tamanho) {	
		pilha = new Jogador[tamanho];
		topo = 0;
		
	}
	
	//Construtor 2: Sem parâmetro
		public Pilha() {
			int tamanho = 150;
			pilha = new Jogador[tamanho];
			topo = 0;
		}
		
	//Getters and Setters
	public int getTopo() {
			return topo;
		}

		public void setTopo(int topo) {
			this.topo = topo;
		}

	//Métodos da pilha:
		
		public int tamanho() {
		    return topo + 1;
		}
		
	public boolean pilhaCheia() {
	
		boolean resp;
		
		if (topo == pilha.length)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean pilhaVazia() {
		
		boolean resp;
		
		if (topo == 0)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public Jogador desempilhar() throws Exception {
	
		Jogador desempilhado;
		
		if (! pilhaVazia()) {
			topo--;
			desempilhado = pilha[topo];
			return desempilhado;
		} else
			throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
	}
	
	public void empilhar(Jogador novoJogador) throws Exception {
		
		if (! pilhaCheia()) {
			pilha[topo] = novoJogador;
			topo++;
			
		} else
			throw new Exception("Não foi possível empilhar: a pilha está cheia!");
	}
	
	public Jogador consultarTopo() throws Exception {
		
		if (! pilhaVazia()) {
			return (pilha[topo-1]);
		} else
			throw new Exception("Não foi possível consultar o elemento do topo da pilha: a pilha está vazia!");
	}


	public void mostrar() throws Exception {
	    if (!pilhaVazia()) {
	        for (int i = topo - 1; i >= 0; i--) {
	        	
	            Jogador jogador = pilha[i];
	            System.out.print("[" + (topo-1-i) + "] ## ");
	            jogador.imprimeDados();
	        }
	    } else {
	        throw new Exception("Pilha vazia");
	    }
	}
}