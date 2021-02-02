package tp.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tp.core.entity.Compte;

@ManagedBean //ManagedBean de JSF
@SessionScoped
@Getter @Setter @NoArgsConstructor
public class ClientComptesMBean {
		private List<Compte> listeComptes; //à afficher dans un tableau.
		//private Client client;
		private Long numClient;
		
		private Double montant; //montant à transférer (virement)
		private Long numCptDeb ; //numero d'un compte à débiter (virement)
		private Long numCptCred ; //numero d'un compte à créditer (virement)
		
		public String effectuerVirement() {
			String suite=null;
			//traitement qui sera plus tard déléguer à un EJB
			for(Compte cpt : listeComptes) {
				if(cpt.getNumero()==numCptDeb) {
					cpt.setSolde(cpt.getSolde() - montant);
				}
				if(cpt.getNumero()==numCptCred) {
					cpt.setSolde(cpt.getSolde() + montant);
				}
			}
			suite="comptes"; //pour réafficher les nouvelles valeurs des comptes
			return suite;
		}
		
		@PostConstruct
		public void initialisation() {
			//V1 : on met des valeurs "en dur" aujourd'hui (jeu de données)
			//v2 : on ira plus tard chercher les valeurs en base de données
			this.listeComptes = new ArrayList<>();
			this.listeComptes.add(new Compte(1L,"compte 1" , 300.0));
			this.listeComptes.add(new Compte(2L,"compte 2 (epargne)" , 200.0));
		}
}
