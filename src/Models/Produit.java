package Models;

public class Produit {
	String reference;
	String designation;
	String uniteMesure;
	Fournisseur fournisseur;
	FamilleProduit familleProduit;
	int stock;
	int stockMinimal;
	Double prixUnitaireHTaxe;
	double tva;
	
	
	public Produit(String reference, String designation, String uniteMesure, Fournisseur fournisseur,
			FamilleProduit familleProduit, int stock, int stockMinimal, Double prixUnitaireHTaxe, double tva) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.uniteMesure = uniteMesure;
		this.fournisseur = fournisseur;
		this.familleProduit = familleProduit;
		this.stock = stock;
		this.stockMinimal = stockMinimal;
		this.prixUnitaireHTaxe = prixUnitaireHTaxe;
		this.tva = tva;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getUniteMesure() {
		return uniteMesure;
	}


	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public FamilleProduit getFamilleProduit() {
		return familleProduit;
	}


	public void setFamilleProduit(FamilleProduit familleProduit) {
		this.familleProduit = familleProduit;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStockMinimal() {
		return stockMinimal;
	}


	public void setStockMinimal(int stockMinimal) {
		this.stockMinimal = stockMinimal;
	}


	public Double getPrixUnitaireHTaxe() {
		return prixUnitaireHTaxe;
	}


	public void setPrixUnitaireHTaxe(Double prixUnitaireHTaxe) {
		this.prixUnitaireHTaxe = prixUnitaireHTaxe;
	}


	public double getTva() {
		return tva;
	}


	public void setTva(double tva) {
		this.tva = tva;
	}
	
	
	

}
