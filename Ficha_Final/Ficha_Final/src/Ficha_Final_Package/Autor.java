package Ficha_Final_Package;

public class Autor {
	private int ID;
	private String Nome;
	private String Biografia;
	
	public Autor() {
		this.ID = 0;
		this.Nome = "";
		this.Biografia = "";
	}
	
	public Autor(int ID, String Nome, String Biografia) {
		this.ID = ID;
		this.Nome = Nome;
		this.Biografia = Biografia;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getBiografia() {
		return Biografia;
	}

	public void setBiografia(String biografia) {
		Biografia = biografia;
	}
}
