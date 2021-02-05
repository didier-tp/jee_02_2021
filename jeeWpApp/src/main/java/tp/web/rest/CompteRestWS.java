package tp.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tp.core.bs.CompteService;
import tp.core.dto.CompteDto;
import tp.core.entity.Compte;

@Path("api-bank/compte")
@Produces("application/json")
@Named
public class CompteRestWS {
	
	@Inject
	private CompteService compteService;
	
	
	//URL=http://localhost:8080/jeeWpApp/rest/api-bank/compte
	@GET
	@Path("")
	public List<CompteDto> getAllComptes(){
		List<CompteDto> listeCompteDto = new ArrayList<>();
		List<Compte> listeCpt = compteService.rechercherTousLesComptes();
		for(Compte cptEntity : listeCpt) {
			listeCompteDto.add(new CompteDto(cptEntity.getNumero(),
		                                     cptEntity.getLabel(),
		                                     cptEntity.getSolde()));
		}
		return listeCompteDto;  //sera automatiquement converti en json
		//via l'interprétation de @Produces("application/json")
	}

}
