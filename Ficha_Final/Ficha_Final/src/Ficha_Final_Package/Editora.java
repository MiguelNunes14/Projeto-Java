package Ficha_Final_Package;

public class Editora {
	private int ID;
	private String Nome;
	private String Morada;
	private String CodigoPostal;
	private String Localidade;
	private String Telefone;
	private String Email;
	private String URL;
	
	public Editora() {
		this.ID = 0;
		this.Nome = "";
		this.Morada = "";
		this.CodigoPostal = "";
		this.Localidade = "";
		this.Telefone = "";
		this.Email = "";
		this.URL = "";
	}
	
	public Editora(int ID, String Nome, String Morada, String CodigoPostal, String Localidade, String Telefone, String Email, String URL) {
		this.ID = ID;
		this.Nome = Nome;
		this.Morada = Morada;
		this.CodigoPostal = CodigoPostal;
		this.Localidade = Localidade;
		this.Telefone = Telefone;
		this.Email = Email;
		this.URL = URL;
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

	public String getMorada() {
		return Morada;
	}

	public void setMorada(String morada) {
		Morada = morada;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public String getLocalidade() {
		return Localidade;
	}

	public void setLocalidade(String localidade) {
		Localidade = localidade;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
}
