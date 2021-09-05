package Models;

public class Clients {
	
	private String codeClients;
	private String matriculefiscaleClient;
	private String nomClient;
	private String prenomClient;
	private int cinClient;
	private int typeClient; // 0 pour etat physique et 1 pour etat morale
	private Adresse adresseClient;
	private int telfixeClient;
	private int telmobileClient;
	private int faxClient;
	private String emailClient;
	private String websiteClient;
	private int etatfiscaleClient; // 0 pour assujiti et 1 pour tva
	private CarteBancaire cartebancaireClient;
	
	
	public Clients(String codeClients, String matriculefiscaleClient, String nomClient, String prenomClient,
			int cinClient, int typeClient, Adresse adresseClient, int telfixeClient, int telmobileClient, int faxClient,
			String emailClient, String websiteClient, int etatfiscaleClient, CarteBancaire cartebancaireClient) {
		super();
		this.codeClients = codeClients;
		this.matriculefiscaleClient = matriculefiscaleClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.cinClient = cinClient;
		this.typeClient = typeClient;
		this.adresseClient = adresseClient;
		this.telfixeClient = telfixeClient;
		this.telmobileClient = telmobileClient;
		this.faxClient = faxClient;
		this.emailClient = emailClient;
		this.websiteClient = websiteClient;
		this.etatfiscaleClient = etatfiscaleClient;
		this.cartebancaireClient = cartebancaireClient;
	}


	public String getCodeClients() {
		return codeClients;
	}


	public void setCodeClients(String codeClients) {
		this.codeClients = codeClients;
	}


	public String getMatriculefiscaleClient() {
		return matriculefiscaleClient;
	}


	public void setMatriculefiscaleClient(String matriculefiscaleClient) {
		this.matriculefiscaleClient = matriculefiscaleClient;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public int getCinClient() {
		return cinClient;
	}


	public void setCinClient(int cinClient) {
		this.cinClient = cinClient;
	}


	public int getTypeClient() {
		return typeClient;
	}


	public void setTypeClient(int typeClient) {
		this.typeClient = typeClient;
	}


	public Adresse getAdresseClient() {
		return adresseClient;
	}


	public void setAdresseClient(Adresse adresseClient) {
		this.adresseClient = adresseClient;
	}


	public int getTelfixeClient() {
		return telfixeClient;
	}


	public void setTelfixeClient(int telfixeClient) {
		this.telfixeClient = telfixeClient;
	}


	public int getTelmobileClient() {
		return telmobileClient;
	}


	public void setTelmobileClient(int telmobileClient) {
		this.telmobileClient = telmobileClient;
	}


	public int getFaxClient() {
		return faxClient;
	}


	public void setFaxClient(int faxClient) {
		this.faxClient = faxClient;
	}


	public String getEmailClient() {
		return emailClient;
	}


	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}


	public String getWebsiteClient() {
		return websiteClient;
	}


	public void setWebsiteClient(String websiteClient) {
		this.websiteClient = websiteClient;
	}


	public int getEtatfiscaleClient() {
		return etatfiscaleClient;
	}


	public void setEtatfiscaleClient(int etatfiscaleClient) {
		this.etatfiscaleClient = etatfiscaleClient;
	}


	public CarteBancaire getCartebancaireClient() {
		return cartebancaireClient;
	}


	public void setCartebancaireClient(CarteBancaire cartebancaireClient) {
		this.cartebancaireClient = cartebancaireClient;
	}
	
	
	
	

}
