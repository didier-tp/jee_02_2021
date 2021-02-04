package tp.core.bs.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.inject.Default; //CDI
import javax.inject.Inject;

import tp.core.bs.CompteService;
import tp.core.dao.CompteDao;
import tp.core.entity.Compte;

/*
 * CompteServiceImpl est un "service métier" (business service)
 * qui délégue au DAO toutes les opérations
 * de persistance (accès base de données)
 */


//@Named 
//@Stateless //EJB Session sans état
@Singleton //javax.ejb.Singleton cas particulier de @Stateless
           //où on est sûr d'avoir un seul exemplaire de la classe en mémoire
@Default //version par défaut
public class CompteServiceImpl implements CompteService {
	
	//@EJB (pour injecter EJB seulement)
	@Inject // (pour injecter n'imporquel type d'élément géré par le conteneur)
	private CompteDao compteDao;
	

	@Override
	public Compte rechercherCompteSelonNum(Long numero) {
		return compteDao.findById(numero);
	}

	@Override
	public List<Compte> rechercherTousLesComptes() {
		return compteDao.findAll();
	}

	@Override
	public List<Compte> rechercherComptesDuClient(Long numeroClient) {
		return compteDao.findByNumClient(numeroClient);
	}

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = compteDao.findById(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		//compteDao.save(cptDeb);
		
		Compte cptCred = compteDao.findById(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
		//compteDao.save(cptCred);
	}

}
