package tp.core.bs.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default; //CDI
import javax.inject.Named;

import tp.core.bs.CompteService;
import tp.core.entity.Compte;

@Named 
@Default //version par défaut
@ApplicationScoped //durée de vie 
public class CompteServiceImpl implements CompteService {

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
	public List<Compte> rechercherComptesDuClient(Long numeroClient) {
		//V1 (temporaire)
		return new ArrayList<Compte>();
	}

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		// TODO Auto-generated method stub

	}

}
