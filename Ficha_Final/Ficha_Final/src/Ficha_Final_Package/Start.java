package Ficha_Final_Package;

public class Start {
	
	public static void main(String[] args) {
		String op;
		do {
			System.out.print("***Menu***");
			System.out.println("\n1 - Listar");
			System.out.println("2 - Procurar");
			System.out.println("3 - Inserir");
			System.out.println("4 - Alterar");
			System.out.println("5 - Sair");
			System.out.println("Escolha: ");
			op = Livros.input.nextLine();
			switch(op) {
			case "1" : 
				do {
					System.out.println("\n1 - Listar Livros");
					System.out.println("2 - Listar Livros e Autores");
					System.out.println("3 - Listar Autores");
					System.out.println("4 - Listar Áreas");
					System.out.println("5 - Listar Editoras");
					System.out.println(" 6 - Sair");
					System.out.println("Escolha: ");
					op = Livros.input.nextLine();
					switch(op) {
					case "1": Livros.ListarLivros(); break;
					case "2": Livros.ListarLivrosAutores(); break;
					case "3": Livros.ListarAutores(); break;
					case "4": Livros.ListarAreas(); break;
					case "5": Livros.ListarEditoras(); break;
					}
				}while(!op.equalsIgnoreCase("6"));
				break;
			case "2":
				do {
					System.out.println("\n1 - Procurar Livros de um Autor");
					System.out.println("2 - Procurar Livro");
					System.out.println("3 - Procurar Autor");
					System.out.println("4 - Procurar Área");
					System.out.println("5 - Procurar Editora");
					System.out.println("6 - Sair");
					System.out.println("Escolha: ");
					op = Livros.input.nextLine();
					switch(op) {
					case "1": Livros.ProcurarAutorLivro(); break;
					case "2": Livros.ProcurarLivro(); break;
					case "3": Livros.ProcurarAutor(); break;
					case "4": Livros.ProcurarArea(); break;
					case "5": Livros.ProcurarEditora(); break;
					}
				}while(!op.equalsIgnoreCase("6"));
				break;
			case "3":
				do {
					System.out.println("\n1 - Inserir Livro");
					System.out.println("2 - Inserir Autor");
					System.out.println("3 - Associar Livro a um Autor");
					System.out.println("4 - Sair");
					System.out.println("Escolha: ");
					op = Livros.input.nextLine();
					switch(op) {
					case "1": Livros.InserirLivro(); break;
					case "2": Livros.InserirAutor(); break;
					case "3": Livros.InserirLivroAutor(); break;
					}
				}while(!op.equalsIgnoreCase("4"));
				break;
			case "4":
				do {
					System.out.println("\n1 - Alterar Livro");
					System.out.println("2 - Alterar Autor");
					System.out.println("3 - Alterar Livro e Autor associados");
					System.out.println("4 - Sair");
					System.out.println("Escolha: ");
					op = Livros.input.nextLine();
					switch(op) {
					case "1": Livros.AlterarLivro(); break;
					case "2": Livros.AlterarAutor(); break;
					case "3": Livros.AlterarLivroAutor(); break;
					}
				}while(!op.equalsIgnoreCase("4"));
				break;
			}
		}while(!op.equalsIgnoreCase("5"));
		System.out.print("Adeus...");
	}

}
