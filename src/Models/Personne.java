package Models;

public class Personne {
	
	private String nomutulisateur;
	private String motdepasse;
	
	
	public Personne(String nomutulisateur, String motdepasse) {
		super();
		this.nomutulisateur = nomutulisateur;
		this.motdepasse = motdepasse;
	}


	public String getNomutulisateur() {
		return nomutulisateur;
	}


	public void setNomutulisateur(String nomutulisateur) {
		this.nomutulisateur = nomutulisateur;
	}


	public String getMotdepasse() {
		return motdepasse;
	}


	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	
	
}
