package tp.core.bs.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped; //CDI
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import tp.core.bs.CompteService;
import tp.core.entity.Compte;

//version simulée sans base de données
//@Named(value = "compteServiceSimu")  
//valeur par défaut (nom de classe avec minuscule au début)
@Named //demande au serveur de créer une instance de cette classe
//plus tard @Stateless (EJB) fera la meme chose en mieux (plus sophistiqué)
@Alternative
@ApplicationScoped //durée de vie 
public class CompteServiceSimu implements CompteService {
	
	private List<Compte> listeComptes = new ArrayList<>();
	
	public CompteServiceSimu() {
		this.listeComptes.add(new Compte(1L,"compte 1" , 301.0));
		this.listeComptes.add(new Compte(2L,"compte 2 (epargne)" , 201.0));
	}
	
	
	@Override
	public List<Compte> rechercherComptesDuClient(Long numeroClient) {
		// V1 (simulation grossière)
		return listeComptes;
	}

	@Override
	public Compte rechercherCompteSelonNum(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> rechercherTousLesComptes() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		// TODO Auto-generated method stub

	}

}
