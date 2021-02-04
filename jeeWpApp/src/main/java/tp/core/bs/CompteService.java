package tp.core.bs;

import java.util.List;

import javax.ejb.Local;

import tp.core.entity.Compte;



@Local  //EJB utilisable localement depuis même JVM (ex: MBean JSF)
public interface CompteService {
	public Compte rechercherCompteSelonNum(Long numero);
	public List<Compte> rechercherTousLesComptes();
	public List<Compte> rechercherComptesDuClient(Long numeroClient);
	
	public void effectuerVirement(double montant,
			                      long numCptDeb,
			                      long numCptCred);
	//....
}
