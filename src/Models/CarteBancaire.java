package Models;

public class CarteBancaire {
	private String banque;
	private String agence;
	private int rib;
	private Fournisseur codeFournisseur;
	private Entreprise idEntreprise;
	private Clients codeClient;
	
	
	public CarteBancaire(String banque, String agence, int rib, Fournisseur codeFournisseur, Entreprise idEntreprise,
			Clients codeClient) {
		super();
		this.banque = banque;
		this.agence = agence;
		this.rib = rib;
		this.codeFournisseur = codeFournisseur;
		this.idEntreprise = idEntreprise;
		this.codeClient = codeClient;
	}


	public String getBanque() {
		return banque;
	}


	public void setBanque(String banque) {
		this.banque = banque;
	}


	public String getAgence() {
		return agence;
	}


	public void setAgence(String agence) {
		this.agence = agence;
	}


	public int getRib() {
		return rib;
	}


	public void setRib(int rib) {
		this.rib = rib;
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
