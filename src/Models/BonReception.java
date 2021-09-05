package Models;

public class BonReception {
	private String code;
	private Fournisseur codeFournisseur;
	private String datebon;
	private String datereception;
	private String codecommande;
	private Double totalepayer;
	
	
	public BonReception(String code, Fournisseur codeFournisseur, String datebon, String datereception,
			String codecommande, Double totalepayer) {
		super();
		this.code = code;
		this.codeFournisseur = codeFournisseur;
		this.datebon = datebon;
		this.datereception = datereception;
		this.codecommande = codecommande;
		this.totalepayer = totalepayer;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Fournisseur getCodeFournisseur() {
		return codeFournisseur;
	}


	public void setCodeFournisseur(Fournisseur codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}


	public String getDatebon() {
		return datebon;
	}


	public void setDatebon(String datebon) {
		this.datebon = datebon;
	}


	public String getDatereception() {
		return datereception;
	}


	public void setDatereception(String datereception) {
		this.datereception = datereception;
	}


	public String getCodecommande() {
		return codecommande;
	}


	public void setCodecommande(String codecommande) {
		this.codecommande = codecommande;
	}


	public Double getTotalepayer() {
		return totalepayer;
	}


	public void setTotalepayer(Double totalepayer) {
		this.totalepayer = totalepayer;
	}
	
	


}
