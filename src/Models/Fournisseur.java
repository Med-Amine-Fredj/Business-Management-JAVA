package Models;

public class Fournisseur {

	private String codeFournisseur;
	private String matriculefiscaleFournisseur;
	private String nomFournisseur;
	private String prenomFournisseur;
	private int cinFournisseur;
	private String typeFournisseur;
	private Adresse adresseFournisseur;
	private int telfixeFournisseur;
	private int telmobileFournisseur;
	private int faxFournisseur;
	private String emailFournisseur;
	private String websiteFournisseur;
	private String etatfiscaleFournissuer; 
	private CarteBancaire cartebancaireFournisseur;
	public Fournisseur(String codeFournisseur, String matriculefiscaleFournisseur, String nomFournisseur,
			String prenomFournisseur, int cinFournisseur, String typeFournisseur, Adresse adresseFournisseur,
			int telfixeFournisseur, int telmobileFournisseur, int faxFournisseur, String emailFournisseur,
			String websiteFournisseur, String etatfiscaleFournissuer, CarteBancaire cartebancaireFournisseur) {
		super();
		this.codeFournisseur = codeFournisseur;
		this.matriculefiscaleFournisseur = matriculefiscaleFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.prenomFournisseur = prenomFournisseur;
		this.cinFournisseur = cinFournisseur;
		this.typeFournisseur = typeFournisseur;
		this.adresseFournisseur = adresseFournisseur;
		this.telfixeFournisseur = telfixeFournisseur;
		this.telmobileFournisseur = telmobileFournisseur;
		this.faxFournisseur = faxFournisseur;
		this.emailFournisseur = emailFournisseur;
		this.websiteFournisseur = websiteFournisseur;
		this.etatfiscaleFournissuer = etatfiscaleFournissuer;
		this.cartebancaireFournisseur = cartebancaireFournisseur;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getMatriculefiscaleFournisseur() {
		return matriculefiscaleFournisseur;
	}
	public void setMatriculefiscaleFournisseur(String matriculefiscaleFournisseur) {
		this.matriculefiscaleFournisseur = matriculefiscaleFournisseur;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getPrenomFournisseur() {
		return prenomFournisseur;
	}
	public void setPrenomFournisseur(String prenomFournisseur) {
		this.prenomFournisseur = prenomFournisseur;
	}
	public int getCinFournisseur() {
		return cinFournisseur;
	}
	public void setCinFournisseur(int cinFournisseur) {
		this.cinFournisseur = cinFournisseur;
	}
	public String getTypeFournisseur() {
		return typeFournisseur;
	}
	public void setTypeFournisseur(String typeFournisseur) {
		this.typeFournisseur = typeFournisseur;
	}
	public Adresse getAdresseFournisseur() {
		return adresseFournisseur;
	}
	public void setAdresseFournisseur(Adresse adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}
	public int getTelfixeFournisseur() {
		return telfixeFournisseur;
	}
	public void setTelfixeFournisseur(int telfixeFournisseur) {
		this.telfixeFournisseur = telfixeFournisseur;
	}
	public int getTelmobileFournisseur() {
		return telmobileFournisseur;
	}
	public void setTelmobileFournisseur(int telmobileFournisseur) {
		this.telmobileFournisseur = telmobileFournisseur;
	}
	public int getFaxFournisseur() {
		return faxFournisseur;
	}
	public void setFaxFournisseur(int faxFournisseur) {
		this.faxFournisseur = faxFournisseur;
	}
	public String getEmailFournisseur() {
		return emailFournisseur;
	}
	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}
	public String getWebsiteFournisseur() {
		return websiteFournisseur;
	}
	public void setWebsiteFournisseur(String websiteFournisseur) {
		this.websiteFournisseur = websiteFournisseur;
	}
	public String getEtatfiscaleFournissuer() {
		return etatfiscaleFournissuer;
	}
	public void setEtatfiscaleFournissuer(String etatfiscaleFournissuer) {
		this.etatfiscaleFournissuer = etatfiscaleFournissuer;
	}
	public CarteBancaire getCartebancaireFournisseur() {
		return cartebancaireFournisseur;
	}
	public void setCartebancaireFournisseur(CarteBancaire cartebancaireFournisseur) {
		this.cartebancaireFournisseur = cartebancaireFournisseur;
	}
	
	
	
	
	

	
}
