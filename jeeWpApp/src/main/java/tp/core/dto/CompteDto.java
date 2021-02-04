package tp.core.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * DTO = Data Transfert Object 
 * (Objet de données transféré à travers le réseau ou ...)
 * souvent indispensable pour les Web Services
 * ---------------
 * VO (Value Object) 
 */

@XmlType(namespace="http://entity.core.tp/")
@XmlRootElement(name="compte")
@XmlAccessorType(XmlAccessType.FIELD) //pour interpréter @XmlTransient sur private
//api JAX-WS = api standard java pour les WS SOAP
//JAX-WS utilise en interne une api JAXB (pour convertir java en XML )
@Getter @Setter @NoArgsConstructor
public class CompteDto implements Serializable{
	
	
	private Long numero; //pas de long mais plutôt Long (valeur null)
	private String label;
	private Double solde; 
	
	
	public CompteDto(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}


	@Override
	public String toString() {
		return "CompteDto [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	
	
}
