package Models;

public class FactureFBL {
	String codeffbl;
	Fournisseur codefournisseur;
	String datefacture;
	String modepayement;
	Double totalehorstva;
	Double totaleavectva;
	Double totaleapayer;
	public FactureFBL(String codeffbl, Fournisseur codefournisseur, String datefacture, String modepayement,
			Double totalehorstva, Double totaleavectva, Double totaleapayer) {
		super();
		this.codeffbl = codeffbl;
		this.codefournisseur = codefournisseur;
		this.datefacture = datefacture;
		this.modepayement = modepayement;
		this.totalehorstva = totalehorstva;
		this.totaleavectva = totaleavectva;
		this.totaleapayer = totaleapayer;
	}
	public String getCodeffbl() {
		return codeffbl;
	}
	public void setCodeffbl(String codeffbl) {
		this.codeffbl = codeffbl;
	}
	public Fournisseur getCodefournisseur() {
		return codefournisseur;
	}
	public void setCodefournisseur(Fournisseur codefournisseur) {
		this.codefournisseur = codefournisseur;
	}
	public String getDatefacture() {
		return datefacture;
	}
	public void setDatefacture(String datefacture) {
		this.datefacture = datefacture;
	}
	public String getModepayement() {
		return modepayement;
	}
	public void setModepayement(String modepayement) {
		this.modepayement = modepayement;
	}
	public Double getTotalehorstva() {
		return totalehorstva;
	}
	public void setTotalehorstva(Double totalehorstva) {
		this.totalehorstva = totalehorstva;
	}
	public Double getTotaleavectva() {
		return totaleavectva;
	}
	public void setTotaleavectva(Double totaleavectva) {
		this.totaleavectva = totaleavectva;
	}
	public Double getTotaleapayer() {
		return totaleapayer;
	}
	public void setTotaleapayer(Double totaleapayer) {
		this.totaleapayer = totaleapayer;
	}

	
}
