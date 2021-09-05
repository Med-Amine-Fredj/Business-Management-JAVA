package Models;

public class LignesBon {
	private BonReception codebon;
	private Produit refproduit;
	private int quantite;
	private Double prixtotalehorstva;
	private Double prixtotaletva;
	private Double prixtotale;
	
	
	public LignesBon(BonReception codebon, Produit refproduit, int quantite, Double prixtotalehorstva, Double prixtotaletva,
			Double prixtotale) {
		super();
		this.codebon = codebon;
		this.refproduit = refproduit;
		this.quantite = quantite;
		this.prixtotalehorstva = prixtotalehorstva;
		this.prixtotaletva = prixtotaletva;
		this.prixtotale = prixtotale;
	}


	public BonReception getCodebon() {
		return codebon;
	}


	public void setCodebon(BonReception codebon) {
		this.codebon = codebon;
	}


	public Produit getRefproduit() {
		return refproduit;
	}


	public void setRefproduit(Produit refproduit) {
		this.refproduit = refproduit;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Double getPrixtotalehorstva() {
		return prixtotalehorstva;
	}


	public void setPrixtotalehorstva(Double prixtotalehorstva) {
		this.prixtotalehorstva = prixtotalehorstva;
	}


	public Double getPrixtotaletva() {
		return prixtotaletva;
	}


	public void setPrixtotaletva(Double prixtotaletva) {
		this.prixtotaletva = prixtotaletva;
	}


	public Double getPrixtotale() {
		return prixtotale;
	}


	public void setPrixtotale(Double prixtotale) {
		this.prixtotale = prixtotale;
	}
	

}
