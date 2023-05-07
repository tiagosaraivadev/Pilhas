import java.util.Scanner;

 public class Jogador {
	// atributos
	private int id, altura, peso, anoNascimento;
	private String nome, universidade, cidadeNascimento, estadoNascimento;
	// scanner
	Scanner sc = new Scanner(System.in);

	Jogador() {
	}

	// construtor 1
	Jogador(
			int id,
			String nome,
			int altura,
			int peso,
			String universidade,
			int anoNascimento,
			String cidadeNascimento,
			String estadoNascimento) {
		this.id = id;
		this.anoNascimento = anoNascimento;
		this.nome = nome;
		this.universidade = universidade;
		this.cidadeNascimento = cidadeNascimento;
		this.estadoNascimento = estadoNascimento;
		this.altura = altura;
		this.peso = peso;
	}

	// construtor 2
	Jogador(String registro) {
		String[] dados = registro.split(",");
		this.id = dados[0].isEmpty() ? -1 : Integer.parseInt(dados[0]);
		this.nome = dados[1].isEmpty() ? "nao informado" : dados[1];
		this.altura = dados[2].isEmpty() ? -1 : Integer.parseInt(dados[2]);
		this.peso = dados[3].isEmpty() ? -1 : Integer.parseInt(dados[3]);
		this.universidade = dados[4].isEmpty() ? "nao informado" : dados[4];
		this.anoNascimento = dados[5].isEmpty() ? -1 : Integer.parseInt(dados[5]);
		this.cidadeNascimento = dados.length < 7 || dados[6].isEmpty() ? "nao informado" : dados[6];
		this.estadoNascimento = dados.length < 8 || dados[7].isEmpty() ? "nao informado" : dados[7];
		}

	// gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	// metodo ler
	public void leDados() {
		System.out.println("Informe o id: ");
		this.id = sc.nextInt();
		System.out.println("Informe o nome: ");
		this.nome = sc.next();
		System.out.println("Informe a altura: ");
		this.altura = sc.nextInt();
		System.out.println("Informe o peso: ");
		this.peso = sc.nextInt();
		System.out.println("Informe a universidade: ");
		this.universidade = sc.next();
		System.out.println("Informe o ano de nascimento: ");
		this.anoNascimento = sc.nextInt();
		System.out.println("Informe  a cidade de nascimento: ");
		this.cidadeNascimento = sc.next();
		System.out.println("Informe  o estado de nascimento");
		this.estadoNascimento = sc.next();
	}
	
//	[1] ## 3169 ## Damir Markota ## 208 ## 102 ## 1985 ## nao informado ## Sarajevo ## Bosnia and Herzegovina ##

	public void imprimeDados() {
		System.out.println(this.id
				+ " ## " + this.nome + " ## " + this.altura + " ## " + this.peso
				+ " ## " + this.anoNascimento + " ## " + this.universidade + " ## " + this.cidadeNascimento + " ## "
				+ this.estadoNascimento + " ##");
	}
	
	// metodo clonar
	public Jogador clone() {
		return new Jogador(
				this.id,
				this.nome,
				this.altura,
				this.peso,
				this.universidade,
				this.anoNascimento,
				this.cidadeNascimento,
				this.estadoNascimento);
	}

}