package tp.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numClient;
	private String prenom;
	private String nom;
	//...
	
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes; //avec get/set

	@Override
	public String toString() {
		return "Client [numClient=" + numClient + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	
	
}
