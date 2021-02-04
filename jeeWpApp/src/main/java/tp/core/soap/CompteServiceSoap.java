package tp.core.soap;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

import tp.core.bs.CompteService;
import tp.core.dto.CompteDto;
import tp.core.entity.Compte;


@Singleton  //ou @Stateless
@WebService(endpointInterface = "tp.core.soap.CompteServiceSEI")
public class CompteServiceSoap implements CompteServiceSEI {
	
	//URL description WSDL = http://localhost:8080/jeeWpApp/CompteServiceSoap?wsdl
	//suverveiller les affichages dans console jboss
	
	@Inject
	private CompteService compteService; //service interne

	@Override
	public CompteDto rechercherCompteSelonNum(Long numero) {
		Compte cptEntity = compteService.rechercherCompteSelonNum(numero);
		return new CompteDto(cptEntity.getNumero(),
				             cptEntity.getLabel(),
				             cptEntity.getSolde());
	}

	@Override
	public List<CompteDto> rechercherTousLesComptes() {
		List<CompteDto> listeCompteDto = new ArrayList<>();
		List<Compte> listeCpt = compteService.rechercherTousLesComptes();
		for(Compte cptEntity : listeCpt) {
			listeCompteDto.add(new CompteDto(cptEntity.getNumero(),
		                                     cptEntity.getLabel(),
		                                     cptEntity.getSolde()));
		}
		return listeCompteDto;
	}

	@Override
	public List<CompteDto> rechercherComptesDuClient(Long numeroClient) {
		List<CompteDto> listeCompteDto = new ArrayList<>();
		List<Compte> listeCpt = compteService.rechercherComptesDuClient(numeroClient);
		for(Compte cptEntity : listeCpt) {
			listeCompteDto.add(new CompteDto(cptEntity.getNumero(),
		                                     cptEntity.getLabel(),
		                                     cptEntity.getSolde()));
		}
		return listeCompteDto;
	}

	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		compteService.effectuerVirement(montant, numCptDeb, numCptCred);
	}

}
