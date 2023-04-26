package Ficha_Final_Package;

public class Area {
	private int ID;
	private String Nome;
	
	public Area() {
		this.ID = 0;
		this.Nome = "";
	}
	
	public Area(int ID, String Nome) {
		this.ID = ID;
		this.Nome = Nome;
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
}
