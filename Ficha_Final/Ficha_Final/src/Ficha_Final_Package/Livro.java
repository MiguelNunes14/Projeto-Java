package Ficha_Final_Package;

public class Livro {
	private int ID;
	private String Titulo;
	private String Resumo;
	private int Editora_id;
	private int Area_id;
	private String Editora;
	private String Area;
	
	public Livro() {
		this.ID = 0;
		this.Titulo = "";
		this.Resumo = "";
		this.Editora_id = 0;
		this.Area_id = 0;
		this.Editora = "";
		this.Area = "";
	}
	
	public Livro(int ID, String Titulo, String Resumo, int Editora_id, int Area_id, String Editora, String Area) {
		this.ID = ID;
		this.Titulo = Titulo;
		this.Resumo = Resumo;
		this.Editora_id = Editora_id;
		this.Area_id = Area_id;
		this.Editora = Editora;
		this.Area = Area;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getResumo() {
		return Resumo;
	}

	public void setResumo(String resumo) {
		Resumo = resumo;
	}

	public int getEditora_id() {
		return Editora_id;
	}

	public void setEditora_id(int editora_id) {
		Editora_id = editora_id;
	}

	public int getArea_id() {
		return Area_id;
	}

	public void setArea_id(int area_id) {
		Area_id = area_id;
	}

	public String getEditora() {
		return Editora;
	}

	public void setEditora(String editora) {
		Editora = editora;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}
}
