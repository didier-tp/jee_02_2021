package tp.core.entity;

// Java Bean (composant java quelconque)
// avec get/set et un constructeur par défaut

// POJO = Plain Old/Ordinary Java Object

//@Entity
public class Compte {
	private Long numero; //pas de long mais plutôt Long (valeur null)
	private String label;
	private Double solde;
	
	
	
	public Compte() {
		super();
	}
	
	
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}



	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	//+get/set et constructeurs
	
}
