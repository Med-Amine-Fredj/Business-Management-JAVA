package Models;

public class Entreprise {

	private int id;
	private String marticulefiscaleE;
	private int raisonsocialeEntreprise; // 0 physique 1 morale
	private String descriptionE;
	private CarteBancaire cartebancaireEntreprise;
	private Adresse addresseEntreprise;
	private int telfixeEntreprise;
	private int telmobieEntreprise;
	private int faxEntreprise;
	private String emailEntreprise;
	private String websiteEntreprise;
	private int etatfiscaleEntreprise; // 0 pour assujiti et 1 pour tva
	
	
	
	public Entreprise(int id, String marticulefiscaleE, int raisonsocialeEntreprise, String descriptionE,
			CarteBancaire cartebancaireEntreprise, Adresse addresseEntreprise, int telfixeEntreprise,
			int telmobieEntreprise, int faxEntreprise, String emailEntreprise, String websiteEntreprise,
			int etatfiscaleEntreprise) {
		super();
		this.id = id;
		this.marticulefiscaleE = marticulefiscaleE;
		this.raisonsocialeEntreprise = raisonsocialeEntreprise;
		this.descriptionE = descriptionE;
		this.cartebancaireEntreprise = cartebancaireEntreprise;
		this.addresseEntreprise = addresseEntreprise;
		this.telfixeEntreprise = telfixeEntreprise;
		this.telmobieEntreprise = telmobieEntreprise;
		this.faxEntreprise = faxEntreprise;
		this.emailEntreprise = emailEntreprise;
		this.websiteEntreprise = websiteEntreprise;
		this.etatfiscaleEntreprise = etatfiscaleEntreprise;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMarticulefiscaleE() {
		return marticulefiscaleE;
	}



	public void setMarticulefiscaleE(String marticulefiscaleE) {
		this.marticulefiscaleE = marticulefiscaleE;
	}



	public int getRaisonsocialeEntreprise() {
		return raisonsocialeEntreprise;
	}



	public void setRaisonsocialeEntreprise(int raisonsocialeEntreprise) {
		this.raisonsocialeEntreprise = raisonsocialeEntreprise;
	}



	public String getDescriptionE() {
		return descriptionE;
	}



	public void setDescriptionE(String descriptionE) {
		this.descriptionE = descriptionE;
	}



	public CarteBancaire getCartebancaireEntreprise() {
		return cartebancaireEntreprise;
	}



	public void setCartebancaireEntreprise(CarteBancaire cartebancaireEntreprise) {
		this.cartebancaireEntreprise = cartebancaireEntreprise;
	}



	public Adresse getAddresseEntreprise() {
		return addresseEntreprise;
	}



	public void setAddresseEntreprise(Adresse addresseEntreprise) {
		this.addresseEntreprise = addresseEntreprise;
	}



	public int getTelfixeEntreprise() {
		return telfixeEntreprise;
	}



	public void setTelfixeEntreprise(int telfixeEntreprise) {
		this.telfixeEntreprise = telfixeEntreprise;
	}



	public int getTelmobieEntreprise() {
		return telmobieEntreprise;
	}



	public void setTelmobieEntreprise(int telmobieEntreprise) {
		this.telmobieEntreprise = telmobieEntreprise;
	}



	public int getFaxEntreprise() {
		return faxEntreprise;
	}



	public void setFaxEntreprise(int faxEntreprise) {
		this.faxEntreprise = faxEntreprise;
	}



	public String getEmailEntreprise() {
		return emailEntreprise;
	}



	public void setEmailEntreprise(String emailEntreprise) {
		this.emailEntreprise = emailEntreprise;
	}



	public String getWebsiteEntreprise() {
		return websiteEntreprise;
	}



	public void setWebsiteEntreprise(String websiteEntreprise) {
		this.websiteEntreprise = websiteEntreprise;
	}



	public int getEtatfiscaleEntreprise() {
		return etatfiscaleEntreprise;
	}



	public void setEtatfiscaleEntreprise(int etatfiscaleEntreprise) {
		this.etatfiscaleEntreprise = etatfiscaleEntreprise;
	}
	
	
	
	
	
	
	
	
}
