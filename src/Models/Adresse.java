package Models;

public class Adresse {
	
	private int numRue;
	private String libellerue;
	private String gouvernerat;
	private String pays;
	private Fournisseur codeFournisseur;
	private Entreprise idEntreprise;
	private Clients codeClient;
	
	
	public Adresse(int numRue, String libellerue, String gouvernerat, String pays, Fournisseur codeFournisseur,
			Entreprise idEntreprise, Clients codeClient) {
		super();
		this.numRue = numRue;
		this.libellerue = libellerue;
		this.gouvernerat = gouvernerat;
		this.pays = pays;
		this.codeFournisseur = codeFournisseur;
		this.idEntreprise = idEntreprise;
		this.codeClient = codeClient;
	}


	public int getNumRue() {
		return numRue;
	}


	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}


	public String getLibellerue() {
		return libellerue;
	}


	public void setLibellerue(String libellerue) {
		this.libellerue = libellerue;
	}


	public String getGouvernerat() {
		return gouvernerat;
	}


	public void setGouvernerat(String gouvernerat) {
		this.gouvernerat = gouvernerat;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Fournisseur getCodeFournisseur() {
		return codeFournisseur;
	}


	public void setCodeFournisseur(Fournisseur codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}


	public Entreprise getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Entreprise idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public Clients getCodeClient() {
		return codeClient;
	}


	public void setCodeClient(Clients codeClient) {
		this.codeClient = codeClient;
	}
	
	


}
