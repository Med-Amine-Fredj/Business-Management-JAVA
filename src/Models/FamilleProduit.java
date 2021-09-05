package Models;

public class FamilleProduit {
		
	private String designation;
	private String codeFamilleProduit;
	private Produit codeProduit;
	
	
	public FamilleProduit(String designation, String codeFamilleProduit, Produit codeProduit) {
		super();
		this.designation = designation;
		this.codeFamilleProduit = codeFamilleProduit;
		this.codeProduit = codeProduit;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getCodeFamilleProduit() {
		return codeFamilleProduit;
	}


	public void setCodeFamilleProduit(String codeFamilleProduit) {
		this.codeFamilleProduit = codeFamilleProduit;
	}


	public Produit getCodeProduit() {
		return codeProduit;
	}


	public void setCodeProduit(Produit codeProduit) {
		this.codeProduit = codeProduit;
	}
	
	
	
	
	
	
	
	
}
