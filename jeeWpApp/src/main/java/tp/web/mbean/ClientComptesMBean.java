package tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tp.core.bs.CompteService;
import tp.core.entity.Compte;

@ManagedBean //ManagedBean de JSF
@SessionScoped
@Getter @Setter 
public class ClientComptesMBean {
		private List<Compte> listeComptes; //à afficher dans un tableau.
		//private Client client;
		private Long numClient=1L;  //temporairement
		
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
		
		/* @Inject demande au container de initialiser la variable 
		 * compteService pour que ça référence un objet existant pris en charge par 
		 * le serveur qui est compatible avec l'interface.
		 * 
		 * @Autowired est l'annotation équivalente de Spring
		 */
		
		@Inject 
		private CompteService compteService =null;
		
		public ClientComptesMBean() {
			super();
			System.out.println("dans constructeur ClientComptesMBean(),compteService= "
					+ compteService);
		}
		
		@PostConstruct
		public void initialisation() {
			
			System.out.println("dans initialisation() préfixé par @PostConstruct,compteService= "
					+ compteService);
			
			
			/* Version préliminaire (pas bien sans @Inject):
            //this.compteService = new CompteServiceImpl();
            //this.compteService = new CompteServiceSimu();
			*/
			
            this.listeComptes = compteService.rechercherComptesDuClient(numClient);
			
			//v2 : on ira plus tard chercher les valeurs en base de données
			
		}
}
