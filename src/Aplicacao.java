import java.util.Scanner;

public class Aplicacao {
	public static int busca(Jogador[] jogadores, int chave) {
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getId() == chave)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		String entrada;
		int qtdComandos;
		Scanner sc = new Scanner(System.in);
		ArquivoTextoLeitura arqLeitura = new ArquivoTextoLeitura("./jogadores.txt");

		int tamanhoArray = 5000, i = 0;
		Jogador[] jogadores = new Jogador[tamanhoArray];

		// le arquivo e salva em array de jogadores
		entrada = arqLeitura.ler(); // descarta a primeira linha
		while (entrada != null) {
			entrada = arqLeitura.ler();
			if (entrada != null)
				jogadores[i] = new Jogador(entrada);
			i++;
		}
		
		//CRIANDO PILHA
		int idJogador;
		int tamanho = 200;
		Pilha pilha;
		pilha = new Pilha(tamanho);
		
		entrada=sc.next();
		// popula a fila com os ids informados antes de "FIM"
				while (!entrada.equals("FIM")) {
					
					idJogador = Integer.parseInt(entrada);
					
					if(!pilha.pilhaCheia()) {
						pilha.empilhar(jogadores[idJogador]);				
					} else {
						pilha.desempilhar();
						pilha.empilhar(jogadores[idJogador]);
					}
					entrada = sc.next();
				}
				
				
				
				// Segunda parte da entrada padrão
				qtdComandos = sc.nextInt();
				sc.nextLine();

				for (int j = 0; j < qtdComandos; j++) {
					String[] comando;
					comando = sc.nextLine().split(" ");
					int id;

					if (comando.length == 2) {
						id = Integer.parseInt(comando[1]);			
						if(!pilha.pilhaCheia()) {
							pilha.empilhar(jogadores[id]);					
						}
						else {
							pilha.desempilhar();
							pilha.empilhar(jogadores[id]);					
						}
					} else if (comando.length == 1) {
						try {
							System.out.println("(R) " + pilha.desempilhar().getNome());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
				
				//CRIANDO NOVA PILHA
				Jogador desempilhado;
				Pilha novaPilha;
				novaPilha = new Pilha(tamanho);
				
				
				//Empilhando a novaPilha
				while (!pilha.pilhaVazia()) {
					
					desempilhado = pilha.desempilhar();
					novaPilha.empilhar(desempilhado);
					
				}
				
				
				novaPilha.mostrar();
				arqLeitura.fecharArquivo();

				sc.close();
	
}
	
	}

