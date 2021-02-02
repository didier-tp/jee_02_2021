package tp.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tp.core.entity.Compte;

@ManagedBean //ManagedBean de JSF
@RequestScoped //ou SessionScoped
@Getter @Setter @NoArgsConstructor
public class ClientComptesMBean {
		private List<Compte> listeComptes; //à afficher dans un tableau.
		//private Client client;
		private Long numClient;
		
		@PostConstruct
		public void initialisation() {
			//V1 : on met des valeurs "en dur" aujourd'hui (jeu de données)
			//v2 : on ira plus tard chercher les valeurs en base de données
			this.listeComptes = new ArrayList<>();
			this.listeComptes.add(new Compte(1L,"compte 1" , 300.0));
			this.listeComptes.add(new Compte(2L,"compte 2 (epargne)" , 200.0));
		}
}
