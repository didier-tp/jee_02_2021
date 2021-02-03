package tp.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Java Bean (composant java quelconque)
// avec get/set et un constructeur par défaut

// POJO = Plain Old/Ordinary Java Object

@Entity
//@Table(name = "Compte")
@Getter @Setter @NoArgsConstructor
@NamedQueries({
  @NamedQuery(name = "Compte.findAll" , query = "SELECT c FROM Compte c") ,
  @NamedQuery(name = "Compte.findByClientNum" , query = "SELECT c FROM Compte c")
})
public class Compte {
	
	//@Id : identificant , clef_primaire
	//@GeneratedValue pour que la valeur de la clef primaire
	// auto-incrémenté par un INSERT INTO SQL
	//remonte bien en mémoire dans l'objet java.
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero; //pas de long mais plutôt Long (valeur null)
	
	//@Column(name="label")
	@Column(length = 64) //associé à VARCHAR(64)
	private String label;
	
	private Double solde; //par défaut stock" dans colonne "solde"
	/*
	@Transient
	private String topSecret; //pas stocké en base
	*/
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	
	
}
