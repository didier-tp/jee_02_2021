package tp.core.bs;

import java.util.List;

import tp.core.entity.Compte;

public interface CompteService {
	public Compte rechercherCompteSelonNum(Long numero);
	public List<Compte> rechercherTousLesComptes();
	public List<Compte> rechercherComptesDuClient(Long numeroClient);
	
	public void effectuerVirement(double montant,long numCptDeb,long numCptCred);
	//....
}
