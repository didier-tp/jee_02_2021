package tp.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tp.core.bs.CompteService;
import tp.core.dto.CompteDto;
import tp.core.dto.VirementDto;
import tp.core.entity.Compte;

@Path("api-bank/compte")
@Produces("application/json")
@Named
public class CompteRestWS {
	
	@Inject
	private CompteService compteService;
	
	//URL=http://localhost:8080/jeeWpApp/rest/api-bank/compte/1
	@GET
	@Path("{id}")
	public CompteDto getCompteByNum(@PathParam("id")long numCpt) {
		Compte cptEntity = compteService.rechercherCompteSelonNum(numCpt);
		return new CompteDto(cptEntity.getNumero(),
		                     cptEntity.getLabel(),
		                     cptEntity.getSolde());
	}
	
	//URL=http://localhost:8080/jeeWpApp/rest/api-bank/compte
	//ou http://localhost:8080/jeeWpApp/rest/api-bank/compte?numClient=1
	@GET
	@Path("")
	public List<CompteDto> getComptesByCriteria(@QueryParam("numClient")Long numClient){
		List<CompteDto> listeCompteDto = new ArrayList<>();
		List<Compte> listeCpt = null;
		System.out.println("numClient="+numClient);
		if(numClient==null)
			listeCpt=compteService.rechercherTousLesComptes();
		else 
			listeCpt=compteService.rechercherComptesDuClient(numClient);
		for(Compte cptEntity : listeCpt) {
			listeCompteDto.add(new CompteDto(cptEntity.getNumero(),
		                                     cptEntity.getLabel(),
		                                     cptEntity.getSolde()));
		}
		return listeCompteDto;  //sera automatiquement converti en json
		//via l'interprétation de @Produces("application/json")
	}
	
	//URL=http://localhost:8080/jeeWpApp/rest/api-bank/compte
	//appelé en mode POST avec dans la partie invisible "body" de la requete
	// { "montant" : 50 , "numCptDeb" : 1 , "numCptCred" : 2 }
	@POST
	@Path("")
	@Consumes("application/json") //pour convertir les données de la partie "body"
	//de la requete HTTP de json en java
	public Response postVirement(VirementDto virement) {
		try {
			compteService.effectuerVirement(virement.getMontant(), 
					                       virement.getNumCptDeb(), 
					                       virement.getNumCptCred());
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
