package tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import tp.core.bs.CompteService;
import tp.core.entity.Compte;

@ManagedBean //ManagedBean de JSF
@RequestScoped
@Getter @Setter 
public class ClientComptesMBean {
		private List<Compte> listeComptes; //à afficher dans un tableau.
		//private Client client;
		private Long numClient=1L;  //temporairement
		
		//Attention: on doit idéalement injecter un Bean qui dure assez longtemps
		//dans un Bean plus éphémère ou de même temps de vie
		//ex: ApplicationScoped ou SessionScoped injecté dans RequestScoped ou SessionScoped
		
		@ManagedProperty("#{loginMBean}") //ok @ManagedProperty() si getLoginMBean() existe
		private LoginMBean loginMBean;
		
		private Double montant; //montant à transférer (virement)
		private Long numCptDeb ; //numero d'un compte à débiter (virement)
		private Long numCptCred ; //numero d'un compte à créditer (virement)
		
		public String effectuerVirement() {
			String suite=null;
			//traitement qui sera plus tard déléguer à un EJB
			try {
				//effectuer le virement en base:
				compteService.effectuerVirement(montant, numCptDeb, numCptCred);
				//réactualiser liste des comptes coté JSF
				//pour afficher les valeurs qui ont changé:
				this.listeComptes = compteService.rechercherComptesDuClient(numClient);
				suite="comptes"; //pour réafficher les nouvelles valeurs des comptes
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
			   .addMessage(null /*global , pas idzonesaisieParticuliere*/, 
					       new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
			
			
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
			/* Version préliminaire (pas bien sans @Inject):
            //this.compteService = new CompteServiceImpl();
            //this.compteService = new CompteServiceSimu();
			*/
			System.out.println("dans initialisation() préfixé par @PostConstruct,compteService= "
					+ compteService);
			
			//Récupérer .numClient du bean loginMBean
			//et le recopier ici dans ClientComptesMBean:
			this.numClient = this.loginMBean.getNumClient();
			System.out.println("ClientComptesMBean.numClient="+numClient);
            this.listeComptes = compteService.rechercherComptesDuClient(numClient);

            /*
            Pour provoquer LazyException si pas EAGER ou bien FETCH:
            String nomClient = listeComptes.get(0).getClient().getNom();
			System.out.println("nomClient="+nomClient);
			*/
		}
}
