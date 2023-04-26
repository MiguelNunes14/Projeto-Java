package Ficha_Final_Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Livros {
	public static Scanner input = new Scanner(System.in);
	public static final String url = "jdbc:mysql://localhost:3306/Livros?serverTomezone=WET";
	public static final String user = "bibliotecario";
	public static final String pwd = "14092015";
	
	public static void ListarLivros() {
		System.out.println("***Lista de Livros***");
		String sql = "SELECT L.ID, L.Titulo, L.Resumo, E.Nome, A.Nome FROM Livro L INNER JOIN Editora E ON L.Editora = E.ID INNER JOIN Area A ON L.Area = A.ID";
		try(Connection conn =DriverManager.getConnection(url,user,pwd); Statement stat = conn.createStatement()){
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tTítulo: " + rs.getString("Titulo"));
				System.out.println("\tResumo: " + rs.getString("Resumo"));
				System.out.println("\tEditora: " + rs.getString("E.Nome"));
				System.out.println("\tÁrea: " + rs.getString("A.Nome"));
			}
		}catch(SQLException e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ListarAutores() {
		System.out.println("***Lista de Autores***");
		String sql = "Select * from Autor;";
		try(Connection conn =DriverManager.getConnection(url,user,pwd); Statement stat = conn.createStatement()){
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
				System.out.println("\tBiografia: " + rs.getString("Biografia"));
			}
		}catch(SQLException e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ListarAreas() {
		System.out.println("***Lista de Áreas***");
		String sql = "Select * from Area;";
		try(Connection conn =DriverManager.getConnection(url,user,pwd); Statement stat = conn.createStatement()){
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
			}
		}catch(SQLException e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ListarEditoras() {
		System.out.println("***Lista de Editoras***");
		String sql = "Select * from Editora;";
		try(Connection conn =DriverManager.getConnection(url,user,pwd); Statement stat = conn.createStatement()){
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
				System.out.println("\tMorada: " + rs.getString("Morada"));
				System.out.println("\tCodigoPostal: " + rs.getString("CodigoPostal"));
				System.out.println("\tLocalidade: " + rs.getString("Localidade"));
				System.out.println("\tTelefone: " + rs.getString("Telefone"));
				System.out.println("\tEmail: " + rs.getString("Email"));
				System.out.println("\tURL: " + rs.getString("URL"));
			}
		}catch(SQLException e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ListarLivrosAutores() {
		System.out.println("***Lista de Livros e Autores***");
		String sql = "select LA.ID, L.Titulo, A.Nome from LivroAutor LA inner join Livro L on LA.Livro = L.ID inner join Autor A on LA.Autor = A.ID";
		try(Connection conn =DriverManager.getConnection(url,user,pwd); Statement stat = conn.createStatement()){
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("LA.ID"));
				System.out.println("\tTítulo: " + rs.getString("L.Titulo"));
				System.out.println("\tAutor: " + rs.getString("A.Nome"));
			}
		}catch(SQLException e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ProcurarAutor() {
		System.out.println("***Procurar Autores***");
		String sql = "select * from Autor where Nome like ?";
		System.out.print("Qual o nome do Autor?");
		String Autor = input.nextLine();
		Autor = "%" + Autor + "%";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Autor);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
				System.out.println("\tBiografia: " + rs.getString("Biografia"));
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}

	public static void ProcurarAutorLivro() {
		System.out.println("***Procurar Livros do Autor***");
		String sql = "select LA.ID, L.Titulo, A.Nome from LivroAutor LA inner join Livro L on LA.Livro = L.ID inner join Autor A on LA.Autor = A.ID where A.Nome like ?";
		System.out.print("Qual o nome do Autor?");
		String Autor = input.nextLine();
		Autor = "%"+ Autor + "%";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Autor);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tLivro: " + rs.getString("L.Titulo"));
				System.out.println("\tAutor: " + rs.getString("A.Nome"));
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ProcurarLivro() {
		System.out.println("***Procurar Livros***");
		String sql = "SELECT L.ID, L.Titulo, L.Resumo, E.Nome, A.Nome FROM Livro L INNER JOIN Editora E ON L.Editora = E.ID INNER JOIN Area A ON L.Area = A.ID where L.Titulo like ?";
		System.out.print("Qual o nome do Livro?");
		String Livro = input.nextLine();
		Livro = "%"+ Livro + "%";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Livro);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tTítulo: " + rs.getString("Titulo"));
				System.out.println("\tResumo: " + rs.getString("Resumo"));
				System.out.println("\tEditora: " + rs.getString("E.Nome"));
				System.out.println("\tÁrea: " + rs.getString("A.Nome"));
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ProcurarArea() {
		System.out.println("***Procurar Areas***");
		String sql = "Select * from Area where Nome like ?";
		System.out.print("Qual o nome da Área?");
		String Area = input.nextLine();
		Area = "%"+ Area + "%";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Area);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void ProcurarEditora() {
		System.out.println("***Procurar Editoras***");
		String sql = "Select * from Editora where Nome like ?";
		System.out.print("Qual o nome da Editora?");
		String Editora = input.nextLine();
		Editora = "%"+ Editora + "%";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Editora);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
				System.out.println("\tMorada: " + rs.getString("Morada"));
				System.out.println("\tCodigoPostal: " + rs.getString("CodigoPostal"));
				System.out.println("\tLocalidade: " + rs.getString("Localidade"));
				System.out.println("\tTelefone: " + rs.getString("Telefone"));
				System.out.println("\tEmail: " + rs.getString("Email"));
				System.out.println("\tURL: " + rs.getString("URL"));
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static int ProcurarEditoraID(String Editora) {
		String sql = "select ID from Editora where Nome = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Editora);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				return rs.getInt("ID");
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		return 0;
	}
	
	public static int ProcurarAreaID(String Area) {
		String sql = "select ID from Area where Nome = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Area);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				return rs.getInt("ID");
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		return 0;
	}
	
	public static int ProcurarLivroID(String Livro) {
		String sql = "select ID from Livro where Titulo = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Livro);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				return rs.getInt("ID");
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		return 0;
	}
	
	public static int ProcurarAutorID(String Autor) {
		String sql = "select ID from Autor where Nome = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setString(1, Autor);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				return rs.getInt("ID");
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		return 0;
	}
	
	public static void InserirLivro() {
		System.out.println("***Inserir Livro***");
		Livro livro = new Livro();
		System.out.print("Título: "); livro.setTitulo(input.nextLine());
		System.out.print("Resumo: "); livro.setResumo(input.nextLine());
		
		do {
			System.out.print("Editora: "); 
			String Editora = input.nextLine();
			livro.setEditora_id(ProcurarEditoraID(Editora));
			if(livro.getEditora_id() != 0) {
				livro.setEditora(Editora);
				break;
			}
			System.out.println("Insira uma editora válida!");
		}while(true);
		
		do {
			System.out.print("Área: "); 
			String Area = input.nextLine();
			livro.setArea_id(ProcurarAreaID(Area));
			if(livro.getArea_id() != 0) {
				livro.setArea(Area);
				break;
			}
			System.out.println("Insira uma área válida!");
		}while(true);
		
		String sql = "Insert into Livro(Titulo, Resumo, Editora, Area) values(?,?,?,?)";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			int i = 1;
			pstat.setString(i++, livro.getTitulo());
			pstat.setString(i++, livro.getResumo());
			pstat.setInt(i++, livro.getEditora_id());
			pstat.setInt(i++, livro.getArea_id());
			int RecordCount = pstat.executeUpdate();
			System.out.println(RecordCount + " registo(s) inserido(s)");
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void InserirAutor() {
		System.out.println("***Inserir Autor***");
		Autor autor = new Autor();
		System.out.print("Autor: "); autor.setNome(input.nextLine());
		System.out.print("Biografia: "); autor.setBiografia(input.nextLine());
		String sql = "Insert into Autor(Nome, Biografia) values(?,?)";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			int i = 1;
			pstat.setString(i++, autor.getNome());
			pstat.setString(i++, autor.getBiografia());
			int RecordCount = pstat.executeUpdate();
			System.out.println(RecordCount + " registo(s) inserido(s)");
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void InserirLivroAutor() {
		System.out.println("***Associar Livro ao Autor***");
		LivroAutor la = new LivroAutor();
		
		do {
			System.out.print("Livro: "); 
			String Livro = input.nextLine();
			la.setLivro_id(ProcurarLivroID(Livro));
			if(la.getLivro_id() != 0) {
				la.setLivro(Livro);
				break;
			}
			System.out.println("Insira um livro válido!");
		}while(true);
		
		do {
			System.out.print("Autor: "); 
			String Autor = input.nextLine();
			la.setAutor_id(ProcurarAutorID(Autor));
			if(la.getAutor_id() != 0) {
				la.setAutor(Autor);
				break;
			}
			System.out.println("Insira um autor válido!");
		}while(true);
		
		String sql = "Insert into LivroAutor(Livro, Autor) values(?,?)";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			int i = 1;
			pstat.setInt(i++, la.getLivro_id());
			pstat.setInt(i++, la.getAutor_id());
			int RecordCount = pstat.executeUpdate();
			System.out.println(RecordCount + " registo(s) inserido(s)");
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void AlterarAutor() {
		System.out.println("***Alterar Autor***");
		System.out.print("Qual o ID do Autor?");
		int id = Integer.parseInt(input.nextLine());
		String sql = "select * from Autor where ID = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				Autor autor = new Autor(rs.getInt("ID"), rs.getString("Nome"), rs.getString("Biografia"));
				System.out.print("\nID: " + rs.getInt("ID"));
				System.out.println("\tNome: " + rs.getString("Nome"));
				System.out.println("\tBiografia: " + rs.getString("Biografia"));
				System.out.print("Quer alterar este Autor (S/N)?");
				String op = input.nextLine();
				if(op.equalsIgnoreCase("S")) {
					System.out.print("Nome: "); autor.setNome(input.nextLine());
					System.out.print("Biografia: "); autor.setBiografia(input.nextLine());
					sql = "Update Autor set Nome = ? , Biografia = ? where ID = ?";
					PreparedStatement pstat2 = conn.prepareStatement(sql);
					int i = 1;
					pstat2.setString(i++, autor.getNome());
					pstat2.setString(i++, autor.getBiografia());
					pstat2.setInt(i++, autor.getID());
					int RecordCount = pstat2.executeUpdate();
					System.out.println(RecordCount + " registo alterado");
					pstat2.close();
				}
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void AlterarLivro() {
		System.out.println("***Alterar Livro***");
		System.out.print("Qual o ID do Livro?");
		int id = Integer.parseInt(input.nextLine());
		String sql = "SELECT L.ID, L.Titulo, L.Resumo, L.Editora, L.Area, E.Nome, A.Nome FROM Livro L INNER JOIN Editora E ON L.Editora = E.ID INNER JOIN Area A ON L.Area = A.ID where L.ID = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				Livro livro = new Livro(rs.getInt("ID"), rs.getString("Titulo"), rs.getString("Resumo"), rs.getInt("Editora"), rs.getInt("L.Area"), rs.getString("E.Nome"), rs.getString("A.Nome"));
				System.out.print("\nID: " + livro.getID());
				System.out.println("\tTítulo: " + livro.getTitulo());
				System.out.println("\tResumo: " + livro.getResumo());
				System.out.println("\tEditora: " + livro.getEditora());
				System.out.println("\tÁrea: " + livro.getArea());
				System.out.print("Quer alterar este Livro (S/N)?");
				String op = input.nextLine();
				if(op.equalsIgnoreCase("S")) {
					System.out.print("Título: "); livro.setTitulo(input.nextLine());
					System.out.print("Resumo: "); livro.setResumo(input.nextLine());
					
					do {
						System.out.print("Editora: "); 
						String Editora = input.nextLine();
						livro.setEditora_id(ProcurarEditoraID(Editora));
						if(livro.getEditora_id() != 0) {
							livro.setEditora(Editora);
							break;
						}
						System.out.println("Insira uma editora válida!");
					}while(true);
					
					do {
						System.out.print("Área: "); 
						String Area = input.nextLine();
						livro.setArea_id(ProcurarAreaID(Area));
						if(livro.getArea_id() != 0) {
							livro.setArea(Area);
							break;
						}
						System.out.println("Insira uma área válida!");
					}while(true);
					sql = "Update Livro set Titulo = ? , Resumo = ?, Editora = ?, Area = ? where ID = ?";
					PreparedStatement pstat2 = conn.prepareStatement(sql);
					int i = 1;
					pstat2.setString(i++, livro.getTitulo());
					pstat2.setString(i++, livro.getResumo());
					pstat2.setInt(i++, livro.getEditora_id());
					pstat2.setInt(i++, livro.getArea_id());
					pstat2.setInt(i++, livro.getID());
					int RecordCount = pstat2.executeUpdate();
					System.out.println(RecordCount + " registo alterado");
					pstat2.close();
				}
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public static void AlterarLivroAutor() {
		System.out.println("***Alterar Autor Associado ao Livro***");
		System.out.print("Qual o ID do LivroAutor?");
		int id = Integer.parseInt(input.nextLine());
		String sql = "select LA.ID, LA.Livro, LA.Autor, L.Titulo, A.Nome from LivroAutor LA inner join Livro L on LA.Livro = L.ID inner join Autor A on LA.Autor = A.ID where LA.ID = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pwd); PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				LivroAutor la = new LivroAutor(rs.getInt("LA.ID"), rs.getInt("LA.Livro"), rs.getString("L.Titulo"), rs.getInt("LA.Autor"), rs.getString("A.Nome"));
				System.out.print("\nID: " + la.getID());
				System.out.println("\tLivro: " + la.getLivro());
				System.out.println("\tAutor: " + la.getAutor());
				System.out.print("Quer alterar este LivroAutor (S/N)?");
				String op = input.nextLine();
				if(op.equalsIgnoreCase("S")) {
					
					do {
						System.out.print("Livro: "); 
						String Livro = input.nextLine();
						la.setLivro_id(ProcurarLivroID(Livro));
						if(la.getLivro_id() != 0) {
							la.setLivro(Livro);
							break;
						}
						System.out.println("Insira um livro válido!");
					}while(true);
					
					do {
						System.out.print("Autor: "); 
						String Autor = input.nextLine();
						la.setAutor_id(ProcurarAutorID(Autor));
						if(la.getAutor_id() != 0) {
							la.setAutor(Autor);
							break;
						}
						System.out.println("Insira um autor válido!");
					}while(true);
					
					sql = "Update LivroAutor set Livro = ? , Autor = ? where ID = ?";
					PreparedStatement pstat2 = conn.prepareStatement(sql);
					int i = 1;
					pstat2.setInt(i++, la.getLivro_id());
					pstat2.setInt(i++, la.getAutor_id());
					pstat2.setInt(i++, la.getID());
					int RecordCount = pstat2.executeUpdate();
					System.out.println(RecordCount + " registo alterado");
					pstat2.close();
				}
			}
		}catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
}




