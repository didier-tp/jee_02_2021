package tp.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Java Bean (composant java quelconque)
// avec get/set et un constructeur par défaut

// POJO = Plain Old/Ordinary Java Object

//@Entity
@Getter @Setter @NoArgsConstructor
public class Compte {
	private Long numero; //pas de long mais plutôt Long (valeur null)
	private String label;
	private Double solde;
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	
	
}
