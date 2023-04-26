package Ficha_Final_Package;

public class LivroAutor {
	private int ID;
	private int Livro_id;
	private String Livro;
	private int Autor_id;
	private String Autor;
	
	public LivroAutor() {
		this.ID = 0;
		this.Livro_id = 0;
		this.Livro = "";
		this.Autor_id = 0;
		this.Autor = "";
	}
	
	public LivroAutor(int ID, int Livro_id, String Livro, int Autor_id, String Autor) {
		this.ID = ID;
		this.Livro_id = Livro_id;
		this.Livro = Livro;
		this.Autor_id = Autor_id;
		this.Autor = Autor;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLivro_id() {
		return Livro_id;
	}

	public void setLivro_id(int livro_id) {
		Livro_id = livro_id;
	}

	public String getLivro() {
		return Livro;
	}

	public void setLivro(String livro) {
		Livro = livro;
	}

	public int getAutor_id() {
		return Autor_id;
	}

	public void setAutor_id(int autor_id) {
		Autor_id = autor_id;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}
}
